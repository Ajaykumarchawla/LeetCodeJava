package Extra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    public void addToList(List<String> list, String endWord, Map<String, String> map) {

        if (endWord.equals("")) {
            return;
        } else {
            String current = map.get(endWord);
            // if(wor)
            addToList(list, current, map);
            list.add(current);
            return;
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> list = new ArrayList<>();

        if (!wordList.contains(endWord)) {
            return list;
        }

        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        Map<String, String> map = new HashMap<>();

        //
        queue.add(beginWord);
        numQueue.add(1);
        map.put(beginWord, "");

        int shortest = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            String word = queue.remove();
            String lastWord = word;
            int count = numQueue.remove();

            if (count >= shortest || count > wordList.size()) {
                System.out.println("continued with : " + word);
                break;
            }
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                for (char c = 'a'; c <= 'z'; c++) {
                    StringBuilder string = new StringBuilder(word);
                    string.setCharAt(i, c);
                    word = string.toString();

                    if (!word.equals(lastWord) && set.contains(word)) {
                        // set.remove(word);
                        // System.out.println("skiped with: " + word+" "+lastWord);
                        System.out.println(word + " " + lastWord);

                    }

                    if (!map.containsKey(word) && !word.equals(lastWord) && set.contains(word)) {
                        // set.remove(word);

                        // System.out.println(word+" "+lastWord);

                        if (word.equals(endWord)) {
                            List<String> newList = new LinkedList<>();
                            addToList(newList, lastWord, map);
                            newList.removeFirst();
                            newList.add(lastWord);
                            newList.add(endWord);
                            list.add(newList);
                            shortest = count + 1;
                            // System.out.println("captured"+ newList);

                        } else {
                            queue.add(word);
                            numQueue.add(count + 1);
                            map.put(word, lastWord);
                        }
                    }

                }
                StringBuilder string = new StringBuilder(word);
                string.setCharAt(i, ch);
                word = string.toString();

            }
        }

        return list;
    }

    public List<List<String>> findLadders2nd(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> list = new ArrayList<>();

        if(!wordList.contains(endWord)){
            return list;
        }

        Set<String> set = new HashSet<>(wordList);
        Queue<List<String>> queue = new LinkedList<>();
        // Queue<Integer> numQueue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        
        //
        List<String> firstlist = new LinkedList<>();
        firstlist.add(beginWord);
        queue.add(firstlist);
        // numQueue.add(1);
        map.put(beginWord,0);


        int shortest = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            // System.out.println(queue+" "+map);

            List<String> newList = queue.remove();
            int count= newList.size();


            String word = newList.get(newList.size()-1);

            // System.out.println(word+" "+queue);
            // System.out.println(word);
            
            if(count>= shortest || count > wordList.size()){
                System.out.println("continued with : "+word);
                break;
            }
            // if(map.containsKey(word) ){
            //     System.out.println("this worked initial: "+map.get(word)+" new count"+count);

                
            // }

            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);

                
                for(char c = 'a';c<='z';c++){
                    StringBuilder string = new StringBuilder(word);
                    string.setCharAt(i, c);
                    word = string.toString();

                    if(set.contains(word) && !newList.contains(word) ){
                        
                        if(word.equals(endWord)){
                            newList.add(word);
                            shortest = newList.size();
                            list.add(newList);
                            
                        }else{
                            int flag =0;
                            if(!map.containsKey(word)){
                                map.put(word,count);
                                flag = 1;
                            }else{
                                // System.out.println("this worked initial: "+map.get(word)+" new count"+count);

                                if(map.get(word)<(count-1)){
                                    continue;
                                }else{
                                    map.put(word,count);
                                    flag = 1;
                                }
                            }
                            if(flag == 1){
                                List<String> newNewList = new LinkedList(newList);
                                newNewList.add(word);
                                queue.add(newNewList);
                            }
                        }
                    }
                }
                StringBuilder string = new StringBuilder(word);
                string.setCharAt(i, ch);
                word = string.toString();

            }
        }

        return list;
    }


    public List<List<String>> findLaddersOptimalYetImpovementNeeded(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> list = new ArrayList<>();

        if(!wordList.contains(endWord)){
            return list;
        }

        Map<String,List<String>> map = new HashMap<>();
        wordList.add(beginWord);
        for(int i = 0;i<wordList.size();i++){
            String word = wordList.get(i);
            for(int j =0;j<word.length();j++){
                char ch = word.charAt(j);
                StringBuilder string = new StringBuilder(word);
                string.setCharAt(j, '*');
                if(map.containsKey(string.toString())){
                    map.get(string.toString()).add(word);
                }else{
                    List<String> newList = new LinkedList<>();
                    newList.add(word);
                    map.put(string.toString(),newList);
                }
            }
        }
        wordList.remove(beginWord);


        Queue<String> queue = new LinkedList<>();
        
        queue.add(beginWord);
        Map<String,List<List<String>>> visited = new HashMap<>();
        List<String> firstlist = new LinkedList<>();
        firstlist.add(beginWord);
        List<List<String>> firstListList = new LinkedList<>();
        firstListList.add(firstlist);
        visited.put(beginWord,firstListList);
        List<String> firstVisitedList = new LinkedList<>();
        
        int shortest = Integer.MAX_VALUE;
        

        while(!queue.isEmpty()){
            String word = queue.remove();
            List<List<String>> lists = visited.get(word);
            for(List<String> newList :lists){
                int count= newList.size();

                if(count>= shortest){
                    return visited.get(endWord);
                }

                for(int i = 0;i<word.length();i++){
                    char ch = word.charAt(i);
                    StringBuilder string = new StringBuilder(word);
                    string.setCharAt(i, '*');
                    String key = string.toString();

                    List<String> hits = map.get(key);
                    for(String hit: hits){
                        if(visited.containsKey(hit)){
                            if(visited.get(hit).get(0).size() == count+1){
                                // System.out.println("this will work now "+hit);
                                List<String> newNewList = new LinkedList(newList);
                                newNewList.add(hit);
                                visited.get(hit).add(newNewList);
                            }
                            continue;
                        }else{
                            List<String> newNewList = new LinkedList(newList);
                                newNewList.add(hit);
                            List<List<String>> newNewListList = new LinkedList<>();
                            newNewListList.add(newNewList);
                                visited.put(hit,newNewListList);
                                queue.add(hit);
                            
                        }
                    }

                }
                if(word.equals(endWord)){
                    return visited.getOrDefault(endWord,new LinkedList<>());
                }
            }
            


            
        }
        System.out.println("returning this");
        return visited.getOrDefault(endWord,new LinkedList<>());
    }
}

"cet"
"ism"
["kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim"]