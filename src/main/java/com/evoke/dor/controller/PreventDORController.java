package com.evoke.dor.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PreventDORController {
	
	
	
	@RequestMapping("/test")
	public String index(HttpServletRequest request) {
		return "index";
	}
	
	
	@PostMapping(value="/aes")
	public String AesTest(HttpServletRequest request) {
	   try {
			String encryptPrice = request.getParameter("pwd");
			String encryptQty = request.getParameter("uname");
			
			Double decryptPrice = Double.parseDouble(decrypt(encryptPrice));
			
			Double decryptQty = Double.parseDouble(decrypt(encryptQty));
			
			System.out.println("Encrypt Price :"+ encryptPrice + " ----> Decrypt Price = " +decryptPrice );
	        System.out.println("Encrypt Quantity :"+encryptQty + " ----> Decrypt Quantity = " +decryptQty );
	        
	        
	        Double totalPrice =decryptPrice*decryptQty;
	        
	        System.out.println("Total Price::"+totalPrice);
	        
	        request.setAttribute("Total", totalPrice);
	        
	        
	   }catch(Exception e) {
		   e.printStackTrace();
	   }

        return "index";
	}
	
	
	
	 public static String decrypt( String input ) {

	        String DL = "__bcdef567kop48__";

	        String[] values = input.split( DL );
	        // last element indicates indices
	        String indices = values[values.length - 1];
	        int[] indexes = convert( indices );
	        SecurityInfo securityInfo = new SecurityInfo( values, indexes );
	        SecurityUtil aesUtil = new SecurityUtil( securityInfo.getKeySize(), securityInfo.getIterationCount() );

	        return aesUtil.decrypt( securityInfo.getSalt(), securityInfo.getIv(), securityInfo.getPassPhrase(), securityInfo.getCipherText() );

	    }
	 
	 
	 public static boolean hasValue( String value ) {
	        return !StringUtils.isEmpty( value );
	    }

	    public static int getInt( String s ) {

	        if ( StringUtils.isNumeric(s) && hasValue( s ) ) {
	            return Integer.parseInt( s );
	        }

	        return 0;
	    }

	    private static int[] convert( String indices ) {
	        String[] indexes = indices.split( "," );

	        int[] ints = new int[indexes.length];

	        for ( int i = 0; i < indexes.length; i++ ) {
	            String s = getNum( indexes[i] );
	            ints[i] = getInt( s );
	        }
	        return ints;
	    }

	    private static String getNum( String s ) {
	        switch ( s ) {
	            case "a":
	                return "0";
	            case "b":
	                return "1";
	            case "c":
	                return "2";
	            case "d":
	                return "3";
	            case "e":
	                return "4";
	            case "f":
	                return "5";
	        }
	        return s;
	    }

}
