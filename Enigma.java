public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        
        String decryptedcode = "";
        int count = 0;
        for(int i =0; i < message.length(); i++){
            int inner = rotors[2].getIndex(message.charAt(i)); 
            char c = rotors[1].getChar(inner);
            int middle = rotors[2].getIndex(c); 
            char d = rotors[0].getChar(middle);
        decryptedcode += d;
        rotate(); 

   /*     if (count == 26)
    { count = 0;
        rotate();
        
    }else {
        count++;
        rotate();
    }
    

        }*/}
    return decryptedcode;

    }


    
    public String encrypt(String message){
        
        String encryptedcode = "";
        //int count=0;
        char a; 
        for(int i =0; i < message.length(); i++){
        a = message.charAt(i); 
        int inner = rotors[0].getIndex(a); 
        char c = rotors[2].getChar(inner);
        int middle = rotors[1].getIndex(c); 
        char d = rotors[2].getChar(middle);
        encryptedcode += d;
        rotate(); 

    //So basically what I'm trying to do is to get the character first element and make that the new char. of the 3rd element
    // Then I repeated the process and make the 2nd element the 3rd element in the array in order to encrypt the original code
    // the last part is the make the new string equal the encrypted code
    //I created a getIndex, and getChar function because the charAt and indexOf doesn't really perform the command I want to implement
    
   // if (count == 26)
    //{ count = 0;
    //   rotate();
    //}else {
    //    count++;
    //    rotate();
    }
    
        
    

    return encryptedcode;
}

    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}