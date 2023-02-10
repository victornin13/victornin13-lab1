public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
    
        
        String newR = this.rotorValues.charAt(this.rotorValues.length()-1) + this.rotorValues.substring(0, this.rotorValues.length()-1);
        this.rotorValues = newR; 
        if(this.rotorValues.indexOf(startChar) == 0)
        {
            return true;
        }
        return false;
           
    }
    

    public int indexOf(char c){
        int index = rotorValues.indexOf(c);
       
        return index;

    }

    public char charAt(int idx){
        return rotorValues.charAt(0);
    }

    public int getIndex(char c) {
       // int i = rotorValues.indexOf(c);
        return rotorValues.indexOf(c);
    }

    public char getChar(int k) {
        return rotorValues.charAt(k);
    }

    
}
    