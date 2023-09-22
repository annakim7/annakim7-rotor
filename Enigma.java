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
        //TODO
        String secretMessage = "";
      //  int count = 0;
        //run a for loop that does each character in the message 
        for(int i = 0; i<message.length(); i++){
          //  int outIndex = rotors[2].indexOf(message.charAt(i));
         //   char middle = rotors[2].charAt(outIndex);
            char character = decryptLetter(message.charAt(i)); 
          //  count++;
            secretMessage += character; 
        }
        return secretMessage;
    }

    private char decryptLetter(char letter){
        int index = rotors[2].indexOf(letter);
        char out = rotors[1].charAt(index);
        int midindex = rotors[2].indexOf(out);
        char outAgain = rotors[0].charAt(midindex);
        rotate();
        return outAgain;
    }

    
    public String encrypt(String message){
        //TODO
        // sets the rotors to specifc strings to read better
        // creates a secret message to return
        String secretMessage = "";
    //    int count = 0;

        //iterates through message
        for(int i = 0; i<message.length(); i++){
            int index = rotors[0].indexOf(message.charAt(i));
            // calls encryptLetter constructor
         //   char in = rotors[0].charAt(index);
            char character = encryptLetter(message.charAt(i)); 
       //     rotate();
            secretMessage += character; 
        }
        return secretMessage;
    }

    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }

    private char encryptLetter(char letter){
        int index = rotors[0].indexOf(letter);
        char out = rotors[2].charAt(index);
        int midindex = rotors[1].indexOf(out);
        char outAgain = rotors[2].charAt(midindex);        
        rotate();
        return outAgain;
    }

    
}


