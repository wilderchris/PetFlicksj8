package com.petflicks.app.Service;

import com.petflicks.app.Exception.PetAlreadyExists;
import com.petflicks.app.Exception.PetNotFoundException;
import com.petflicks.app.Exception.UserNotFoundException;
import com.petflicks.app.Models.Pet;

public class PetServiceImpl implements PetService {

	@Override
	public Pet add(Pet newPet) throws PetAlreadyExists {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pet getPetById(int userId) throws PetNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pet getPetsByUsername(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pet update(Pet pet) throws PetNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pet deletePet(Pet pet) throws PetNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
