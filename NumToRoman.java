
private static final String[] RCODE = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
private static final int[] BVAL  = {1000, 900, 500, 400,  100,   90,  50,   40,  10, 9,   5,   4,  1};
    
public static String binaryToRoman( int binary ){
    if( binary <= 0 || binary >= 4000) {
      throw new NumberFormatException("Value outside roman numeral range.");
    }

    String roman = "";    // Roman notation will be accumulated here.

    // Loop from biggest value to smallest, successively substracting,
    // from the binary value while adding to the roman representation.
    for(int i = 0; i < RCODE.length; i++){
        System.out.println("[" + i + "] binary: " + binary + " (greater than BVAL[" + i + "]: "+ BVAL[i] + "???)");
        System.out.println("[" + i + "] roman: " + roman);
        System.out.println("-------------------------------");

        // 여기서부터 실제 코드 시작...
        while(binary >= BVAL[i]){        // if entered binary value is grater than BVAL[i].. ex) 346 >= 1000?, 346 >= 900? 
            binary -= BVAL[i]; System.out.println("binary: " + binary + " | BVAL["+i+"]: " + BVAL[i]); //  ex) 346-100           
            roman += RCODE[i]; System.out.println("roman: " + roman+ " | RCODE["+i+"]: " +RCODE[i]);   // 
        }
    }
    return roman;
}

public static void main(String[] args) {

    System.out.println("Enter binary int: ");
    Scanner scanner = new Scanner(System.in);
    int bin = scanner.nextInt();
    System.out.println("-------------------------------");

    String romConverted = binaryToRoman(bin);
    System.out.println("\nEntered Int: " + bin + " ==> converted to '" + romConverted + "'");        
}

