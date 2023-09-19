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
        String inner = rotorInit[0];
        String middle = rotorInit[1];
        String out = rotorInit[2];

        String secretMessage = " ";
        for(int i = 0; i<out.length(); i++){
            if(message.charAt(0) == out.charAt(i)){
                char find = middle.charAt(i);
                for(int j = 0; j<out.length(); j++){
                    if(find == out.charAt(j)){
                        char findOut = inner.charAt(j);
                        secretMessage += findOut;
                        rotate(); //counterclockwise?
                        break;
                    }
                }
            }
        }

        // rotate inner counterclockwise
        // find the letter in the outer line
        // align with middle
        // find with outer again
        // align with inner
        //for look length = lenght of string 

     //   return secretMessage;
    }
    
    public String encrypt(String message){
        //TODO
        String inner = rotorInit[0];
        String middle = rotorInit[1];
        String out = rotorInit[2];
        String secretMessage = " ";

        for(int i = 0; i<inner.length();i++){
            if(message.charAt(0) == inner.charAt(i)){
                char find = out.charAt(i);
                for(int j = 0; j<middle.length();j++){
                    if(find == middle.charAt(j)){
                        char findOut = out.charAt(j);
                        secretMessage += out.charAt(j);
                        rotate();
                        break;
                    }
                }
            }

        }
    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
//    return secretMessage;
}


