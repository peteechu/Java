public class RSA {
    public static void main(String[] args){
        int p = 11;
        int q = 13;
        String message = "RASTAMAN";
        RSAEncryptionAndDecryption(p, q, message);
    }

    public static int ord(char text){
        int code;
        code = (int) text;
        return code;
    }
    
    public static char chr(double character){
        char converted;
        converted = (char) character;
        return converted;
    }

    public static double Pow(double num, int exp){

        double result =1;
        
        for (int i = 0; i < exp; i++) {
        
        result *= num;
        
        }
        
        return result;
    }

    public static void RSAEncryptionAndDecryption(int p, int q, String string){
        int n = p * q;
        int z = (p - 1) * (q - 1);
        int e;
        int d;
        int i;
        char encryptedChar;
        String encryptedString = "";
        char decryptedChar;
        String decryptedString = "";

        for (e = 1; e < n; e++){
            if( (z % e) != 0){
                break;
            }
        }

        for (d = 1; d < 1000; d++){
            if (d != z && (e*d-1) != z){
                if(((e*d)-1)%z == 0){
                    break;
                }
            }
        }
        System.out.println(n);
        System.out.println(z);
        System.out.println(e);
        System.out.println(d);

        for(i=0;i<string.length();i++){
           char txt = string.charAt(i);
           char upper = Character.toUpperCase(txt);
           double s = (double) upper;
           double num = Pow(s, e);
           encryptedChar = (char) (num%n);

           encryptedString += encryptedChar;
        }

        
        for(i=0;i<encryptedString.length();i++){
            int s = (int) (encryptedString.charAt(i));
            double num = Math.pow(s, d);
            decryptedChar = (char) (num%n);
            decryptedString += decryptedChar;
         }

       // for (i=0; i<string.length();i++){
       //     int s = ord(string.charAt(i));
       //     int num = (int) Math.pow(s, e);
       //     encryptedChar = chr(num % n);
       //     encryptedString = encryptedString + encryptedChar; 
       // }
        System.out.println(encryptedString);

        

        //for (i=0; i<encryptedString.length();i++){
        //    int s = ord(encryptedString.charAt(i));
        //    int num = (int) Math.pow(s, d);
        //    decryptedChar = chr(num % n);
        //    decryptedString = decryptedString + decryptedChar; 
        //}

        System.out.println(decryptedString);

        }

    }
