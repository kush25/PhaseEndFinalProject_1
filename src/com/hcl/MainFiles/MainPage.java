package com.hcl.MainFiles;

import java.util.Arrays;
import java.util.Scanner;
import com.hcl.CExceptions.UnableToDelete;
import com.hcl.CExceptions.UnableToSearchFile;
import com.hcl.Interfaces.FileMethod;
import java.io.File;
import java.io.IOException;

public class MainPage implements FileMethod {

	static String path1 = System.getProperty("user.dir") + "\\" + "DocumentsFolder";
	static Scanner scan = new Scanner(System.in);
	static MainPage mpg = new MainPage();

	public static void main(String[] args) throws UnableToDelete, UnableToSearchFile {

		System.out.println("**************************************************");
		System.out.println("Welcome to the Lockedme.com Screen");
		System.out.println("Developed by Kush Gandhi at HCL America");

		System.out.println("**************************************************");
		System.out.println("Your Current path is " + " " + path1);
		
		mainChoices();
	

	}

	
	private static void mainChoices() throws UnableToDelete, UnableToSearchFile {
		String ch1 = "You can choose from the below options:" + "\n";
		String ch2 = "1) To Display the File Names in Directory:";
		String ch3 = "2) To Add/Delete/Search files:";
		String ch4 = "3) Close the Applications";
		String ch5 = "**************************************************";
		System.out.print(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		System.out.println(ch5);

		
		
		int mainops = 0;
		try {
		mainops = Integer.parseInt(scan.next());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		switch (mainops) {

		case 1:
			mpg.Files();
			break;
		case 2:
			Fileops();
			break;
		case 3:
			mpg.closeApp();;
			break;
		
		default:
			System.out.println("Invalid Choice");
			break;

		}

		mainChoices();
	}

	
	private static void Fileops() throws UnableToDelete, UnableToSearchFile {
		System.out.println("************************************************");
		String op1 = "Which operations do you want to perform:";
		String op2 = "1) Add 2) Delete  3) Search  4)Main Menu";
		System.out.println(op1);
		System.out.println(op2);

		int opschoice = 0;
		try {
		opschoice = Integer.parseInt(scan.next());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		switch (opschoice) {

		case 1:
			mpg.addFiles();
			break;
			
		case 2:
			mpg.fileDelete();
			break;
			
		case 3:
			mpg.searchFile();
			break;
			
		case 4:
			mainChoices();
			break;

		default:
			System.out.println("Please Make a proper choice from options available");
			break;

		}
		Fileops();
	}

	@Override
	public void Files() {
		System.out.println(path1);
		
		path1 =   path1 + "\\";
		File file = new File(path1);
		String[] arr = file.list();
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr) + "\n");

	}

	@Override
	public void addFiles() {
		System.out.println("Enter the file name with proper format/extensions");

		String filename = scan.next();
		
		String adding = path1 + "\\"+ filename;
	
		File newfile = new File(adding);

		try {
			if (newfile.createNewFile()) {

				System.out.println("File Created " + "\n" + "File Name " + newfile.getName());
				System.out.println("File Created at " + newfile.getAbsolutePath());
	
			} else {
				System.out.println("File exists");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void fileDelete() throws UnableToDelete {
		System.out.println("File name to be deleted");
		
		String delfile = scan.next();
		
		String deleting = path1 + "\\"+ delfile;
		File del = new File(deleting); 
	   try {
		   
		if (del.delete()) { 
	      System.out.println("Deleted the file: " + del.getName());
	    } else {
	     throw new UnableToDelete("Cannot Delete File, because your inputed File Name not found");
	    } 
		
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		try {
			mainChoices();
		} catch (UnableToDelete | UnableToSearchFile e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	}
	
	
	@Override
	public void searchFile() throws UnableToSearchFile {
		System.out.println("File name to be searched");
		
		String searchfile = scan.next();
		String loc = path1 + "\\" + searchfile;
		
		try {
		File sfile = new File(loc);
	    if (sfile.exists()) {
	    	System.out.println("File Name " + sfile.getName()+  " " +"Found");
	    	System.out.println("Found at " + " " + sfile.getAbsolutePath());
	    }
	    else {
	    	 throw new UnableToSearchFile("Your entered file does not exist");
	    }
		
		}catch(Exception e) {
		System.out.println(e.getMessage());
		}
	}


	public static void closeApp() {
		scan.close();
		System.out.println("App Closed");
		
		System.exit(0);
		
	}


}
