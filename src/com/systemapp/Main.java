package com.systemapp;

public class Main {

	public static void main(String[] args) {
      /*  String link = "https://www.cs.bham.ac.uk/~exr/lectures/opsys/10_11/lectures/os-dev.pdf";
        File out = new File("C:\\Users\\hp\\Desktop\\out.pdf");
        Download d = new Download(link, out);
        d.start();*/
		
		Loginh h =  new Loginh();
	    Loginh.login();
	   	h.start();


	}

}
