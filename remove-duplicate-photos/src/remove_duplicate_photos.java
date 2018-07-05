import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;

public class remove_duplicate_photos{
	
	public static void main(String [] args)throws Exception{
		    try{
		    int count=0;
		    HashSet<String> hashset=new HashSet<String>();
		    File path = new File("C:\\Users\\frank\\a");
		    ArrayList<byte[]> imageCollection = new ArrayList<byte[]>();
		    File [] files = path.listFiles();
		    for (int i = 0; i < files.length; i++){
		    	   if (files[i].isFile()){ //this line weeds out other directories/folders
		    	      //imageCollection.add(Files.readAllBytes(files[i].toPath()));
		    		  // System.out.println(files[i]);
		    	        MessageDigest md = MessageDigest.getInstance("MD5");
				        byte[] mdbytes = md.digest(Files.readAllBytes(files[i].toPath()));	
				        imageCollection.add(mdbytes);
				       
				   
				        StringBuffer sb = new StringBuffer();  
				        for (int i1 = 0; i1 < mdbytes.length; i1++) {
				          sb.append(Integer.toString((mdbytes[i1] & 0xff) + 0x100, 16).substring(1));
				        }
				        

				        if (hashset.add(sb.toString()) == false) {
				        	Files.move(files[i].toPath(),Paths.get("C:\\Users\\frank\\a\\a\\"+files[i].getName()), StandardCopyOption.ATOMIC_MOVE);
				        	  System.out.println(files[i].toString());
				        	  count++;
				         }
				        //imageCollection.trimToSize();	
		    	   }
		    }
		    
		    System.out.println("Completed "+count);
		/*    Iterator<byte[]> iterator = imageCollection.iterator();
			while (iterator.hasNext()) {
				 MessageDigest md = MessageDigest.getInstance("MD5");
			        byte[] mdbytes = md.digest(iterator.next());		     
			        StringBuffer sb = new StringBuffer();  
			        for (int i = 0; i < mdbytes.length; i++) {
			          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
			        }
			        System.out.println("Digest(in hex format):: " + sb.toString());
			}
		    	
		    	
		      //f = new File("D:\\20180621_101210.jpg"); //image file path
		      Path path1 = Paths.get("D:\\20180621_101210.jpg");
		      
		      System.out.println(path1);
		      byte[] fileContents =  Files.readAllBytes(path1);
		      System.out.println(fileContents.length);

		      MessageDigest md = MessageDigest.getInstance("MD5");
		        byte[] mdbytes = md.digest(fileContents);		     
		        //convert the byte to hex format method 1
		        StringBuffer sb = new StringBuffer();  
		        for (int i = 0; i < mdbytes.length; i++) {
		          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
		        }

		        System.out.println("Digest(in hex format):: " + sb.toString());*/

		    }catch(Exception e){
		      System.out.println("Error: "+e);
		    }
		    
	}
}

