package com.petflicks.app.Api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.web.multipart.MultipartFile;

import io.github.cdimascio.dotenv.Dotenv;

public class S3ApiUtil {

	static Dotenv dotenv = Dotenv.load();

	
	// s3 api put 
		static String actionURL = dotenv.get("MY_API_URL");//{filename}
		
	
	public static String upload(File file) {

        String towHyphens = "--";   // Define connection strings
        String boundary = "******"; // Define the delimitation string
        String end = "\r\n";    //Define end newline string
        try {
            // Create URL objects
            URL url = new URL(actionURL + file.getName());
            // Get the connection object
            URLConnection urlConnection = url.openConnection();
            // Set the input stream allowed to input data to the local machine
            urlConnection.setDoOutput(true);
            // Setting allows output streams to output data to servers
            urlConnection.setDoInput(true);
            // Setting up not to use caching
            urlConnection.setUseCaches(false);
            // Set the content type in the request parameter to be multipart/form-data and the demarcation line of the request content to be ******
            urlConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

            // Getting the output stream from the connection object
            OutputStream outputStream = urlConnection.getOutputStream();
            // Instantiate the data output stream object to input the output stream
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // Traversing the length of the file path, writing all the files of the path under the path array to the output stream
          //  for (int i = 0; i < filePaths.length; i++) {
                // Remove file path
              //  String filePath = filePaths[i];
                // Get the file name
                String fileName = file.getName();
                // Write a partitioner to the data output stream
                dataOutputStream.writeBytes(towHyphens + boundary + end);
                // Write the file parameter name and file name to the data output stream
                dataOutputStream.writeBytes("Content-Disposition:form-data;name=file;filename=" + fileName + end);
                // Write the end flag to the data output stream
                dataOutputStream.writeBytes(end);

                // Instantiate file input stream objects, pass file paths in, and read files on disk into memory
                FileInputStream fileInputStream = new FileInputStream(file);
                // Define buffer size
                int bufferSize = 1024;
                // Define byte array objects to read buffer data
                byte[] buffer = new byte[bufferSize];
                // Define an integer to store the length of the file currently read
                int length;
                // The loop reads 1024 bytes of data from the file output stream and assigns the length of each read to the length variable until the file is read, with the value of -1 ending the loop.
                while ((length = fileInputStream.read(buffer)) != -1) {
                    // Write data to the data output stream
                    dataOutputStream.write(buffer, 0, length);
                }
                // Each time a complete file stream is written, an end flag is written to the data output stream.
                dataOutputStream.writeBytes(end);
                // Close File Input Stream
                fileInputStream.close();

           // }
            // Write a delimiter into the data output stream
            dataOutputStream.writeBytes(towHyphens + boundary + towHyphens + end);
            // Refresh data output stream
            dataOutputStream.flush();

            // Getting byte input stream from connection object
            InputStream inputStream = urlConnection.getInputStream();
            // Instantiate character input stream objects, wrapping byte streams into character streams
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            // Create an input buffer object that passes in the input character stream object
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Create a string object to receive each string read from the input buffer
            String line;
            // Create a variable string object to load the final data of the buffer object, and store all the data in the response in the object using string addition
            StringBuilder stringBuilder = new StringBuilder();
            // Read the buffer data line by line using a loop, and assign one line of string data to the line string variable each time until the read behavior space-time identifies the end of the loop.
            while ((line = bufferedReader.readLine()) != null) {
                // Append the data read by the buffer to the variable character object
                stringBuilder.append(line);
            }

            // Close the open input stream in turn
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            // Close the open output stream in turn
            dataOutputStream.close();
            outputStream.close();

            // Returns the data that the server responds to
            return stringBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
}
}
