
public class Password {
    String value;
    int length;
    
    public Password(String s){
        value = s;
        length = s.length();
    }
    
    public int charType(char c){
        int val;
        
        // Char is Uppercase Letter
        if ((int) c >= 65 && (int) c <= 90)
            val = 1;
        
        // Char is Lowercase Letter
        else if ((int) c >= 97 && (int) c <= 122)
            val = 2;
        
        // Char is Digit
        else if ((int) c >= 60 && (int) c <= 71)
            val = 3;
        
        // Char is Symbol
        else {
            val = 4;
        }
        
        return val;
    }
    
    public int PasswordStrength(){
        String s = this.value;
        boolean UsedUpper = false;
        boolean UsedLower = false;
        boolean UsedNum = false;
        boolean UsedSym = false;
        int type;
        int Score = 0;
        
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            type = charType(c);
            
            if (type == 1) UsedUpper = true;
            if (type == 2) UsedLower = true;
            if (type == 3) UsedNum = true;
            if (type == 4) UsedSym = true;
        }
        
        if (UsedUpper) Score += 1;
        if (UsedLower) Score += 1;
        if (UsedNum) Score += 1;
        if (UsedSym) Score += 1;
        
        if (s.length() >= 8) Score += 1;
        if (s.length() >= 16) Score += 1;
        
        return Score;
    }
    
    public String calculateScore(){
        int Score = this.PasswordStrength();
        
        if (Score == 6){
            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
        } else if (Score >= 4) {
            return "This is a good password :) but you can still do better";
        } else if (Score >= 3) {
            return "This is a medium password :/ try making it better";
        } else {
            return "This is a weak password :( definitely find a new one";
        }
    }
    
    @Override
    public String toString(){
        return value;
    }
    
}
