package com.hcl.Interfaces;

import com.hcl.CExceptions.UnableToDelete;
import com.hcl.CExceptions.UnableToSearchFile;

public interface FileMethod {
	
	public void Files();	
	public void addFiles();
	public void fileDelete() throws UnableToDelete, UnableToSearchFile;
	public void searchFile() throws UnableToSearchFile;


}
