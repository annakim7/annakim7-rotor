public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());

    }
    
    public boolean rotate(){
        //TODO
        rotorValues = rotorValues.substring(1,rotorValues.length()) + rotorValues.charAt(0);

        if(rotorValues.charAt(0)==(startChar)){
            return true;
        }
        else{
            return false;
        }
    }
    

    public int indexOf(char c){
        //TODO
        for(int i = 0; i<rotorValues.length(); i++){
            if(this.rotorValues.charAt(i) == c){
                return i;
            }
        }
    }

    public char charAt(int idx){
        //TODO
        return charAt(idx);
    }
}
    
