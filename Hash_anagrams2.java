import java.util.*; 
import java.lang.*;
import java.io.*;  

class TestClass {          
    
    public static void displayList(List<String> a){               
        for(int i = 0; i < a.size(); i++){             
            System.out.print(a.get(i) + " | ");             
        }     
    }      
    
    public static void displayList2D(ArrayList<ArrayList<Integer>> a){               
        for(int i = 0; i < a.size(); i++){             
            for(int j = 0; j < a.get(i).size(); j++){                 
                System.out.print(a.get(i).get(j));             
            }             
            System.out.println();         
        }     
    }      
    

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        if(a == null || a.size() == 0) return null;
        
        Hashtable<String, ArrayList<Integer>> htable = new Hashtable<String, ArrayList<Integer>>();
        
        for(int i = 0; i < a.size(); i++){
            String sorted = sortChars(a.get(i));
            if(!htable.containsKey(sorted)){
                htable.put(sorted, new ArrayList<Integer>());
                htable.get(sorted).add(i+1);
            } else{
                ArrayList<Integer> anagram = htable.get(sorted);
                anagram.add(i+1);
            }
        }
        
        /*
        List<Integer> sortedTable = new ArrayList<String>(htable.keySet());
        Collections.sort(sortedTable);
        //*/
        /*
        ArrayList myArrayList=new ArrayList(myhash.entrySet());        
        Collections.sort(myArrayList, new Comparator() {
            public int compare( Object o1 , Object o2 )
            {
                Map.Entry e1 = (Map.Entry) o1 ;
                Map.Entry e2 = (Map.Entry) o2 ;
                Integer first = (Integer)e1.getValue();
                Integer second = (Integer)e2.getValue();
                return first.compareTo( second );
            }
        });
        //*/
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for(String key : htable.keySet()){
            ArrayList<Integer> anagram = htable.get(key);
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i < anagram.size(); i++){
                temp.add(anagram.get(i));
            }
            res.add(temp);
        }
        //*/
        //displayList2D(res);
        
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {    
            @Override
            public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2) {
                return a1.get(0).compareTo(a2.get(0));
            }               
        });
    
        return res;
    }
    
    public static String sortChars(String s){
        char[] str = s.toCharArray();
        Arrays.sort(str);
        return new String(str);
    }
    
    public static void main(String args[] ) throws Exception {         
        Scanner sc = new Scanner(System.in);         
        int t = sc.nextInt();                  
    
        List<String> arr = new ArrayList<String>();                  
        
        while(sc.hasNext()){             
            
            for(int i = 0; i < t; i++){                 
                arr.add(sc.next());              
            }             
        }                  
        
        //System.out.println("arr.size: " + arr.size() );         
        //displayList(arr);           
        displayList2D(anagrams(arr));
    } 
    
    /* Testcase
    - Testcase #1
    Input: cat dog god tca
    Output: [1,4],[2,3]
  
    - Testcase #2
    Input: 5 cat dog god tca ttt
    Output: [1,4],[2,3],[5]
  
    - Testcase #3
    Input: 0
    Output: []
    
    - Testcase #4
    Input: 8 abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb
    Output: [1],[2],[3,5],[4],[6],[7],[8]
    //*/
}
    
