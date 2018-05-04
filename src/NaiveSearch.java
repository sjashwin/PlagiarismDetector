class NaiveSearch {

    private String text, pattern;


    /**
     *
     * @param text - text in which the pattern needs to be found.
     * @param pattern - pattern that is to be found.
     */
    NaiveSearch(String text, String pattern) {
        long start = System.currentTimeMillis() ;
        this.text = text;
        this.pattern = pattern;
        System.out.println(search());
        System.out.println("Time Elapsed :" + String.valueOf(System.currentTimeMillis()-start)) ;
    }

    /**
     *
     * @return boolean - result based on the pattern found.
     */
    private boolean search() {
        int found , temp ;
        for (int i = 0; i < (text.length() - pattern.length() - 1); i++) {
            found = 0;
            temp = i;
            for (char p : pattern.toCharArray()) {
                if (text.charAt(temp) == p){
                    found++;
                    if (found == pattern.length())
                        return true;
                } else
                    break;
                temp++;
            }
        }
        return false;
    }
}