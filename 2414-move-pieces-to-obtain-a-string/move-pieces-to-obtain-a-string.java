class Solution {
    public boolean canChange(String start, String target) {

        int sl = start.length();
        int tl = target.length();

        int sp = 0;
        int tp = 0;

        while (sp < sl && tp < tl) {
            if (start.charAt(sp) == '_')
                sp++;
            else if (target.charAt(tp) == '_')
                tp++;
            else if ((start.charAt(sp) == 'L' && target.charAt(tp) == 'R') || 
                     (start.charAt(sp) == 'R' && target.charAt(tp) == 'L'))
                return false;
            else if (start.charAt(sp) == 'L' && target.charAt(tp) == 'L') {
                if (tp > sp) return false;

                sp++;
                tp++;
            } else if (start.charAt(sp) == 'R' && target.charAt(tp) == 'R') {
                if (tp < sp) return false;

                sp++;
                tp++;
            }
        }

      
        while (sp < sl) {
            if (start.charAt(sp) != '_') return false;
            sp++;
        }
        while (tp < tl) {
            if (target.charAt(tp) != '_') return false;
            tp++;
        }
        return true;
    }
}