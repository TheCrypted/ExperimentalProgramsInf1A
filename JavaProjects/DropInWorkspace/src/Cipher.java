public class Cipher {
    private static final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public static int charToInt(char a){
        for(int i=0; i<alphabet.length; i++){
            if(alphabet[i] == a){
                return i;
            }
        }
        return -1;
    }
    public static char intToChar(int value) {
        return alphabet[value];

    }
    public static String encipher(String original, String Key) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<original.length(); i++){
            sb.append(intToChar((charToInt(original.charAt(i)) + charToInt(Key.charAt(i)))%26));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String ciphertext = encipher("SUPERSECRETMESSAGE", "MYSUPERDUPERSECRETCKEY");
        System.out.print(ciphertext.toLowerCase());
    }
}
