// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Sample(){
    /*****************PROBLEM-2***************/
    //TC:0(n*2^N)
//SC:0(n)
    class Solution {
        List<String> result;
        List<List<Character>> blocks;
        public String[] expand(String s) {
            if(s==null || s.length()==0){
                return new String[]{};
            }
            blocks=new ArrayList<>();
            result=new ArrayList<>();
            int i=0;
            while(i<s.length()){
                List<Character> block=new ArrayList<>();
                if(s.charAt(i)=='{'){
                    i++;
                    while(s.charAt(i)!='}'){
                        if(s.charAt(i)!=','){
                            block.add(s.charAt(i));
                        }
                        i++;
                    }
                }else{
                    block.add(s.charAt(i));
                }
                Collections.sort(block);
                blocks.add(block);
                i++;
            }
            backtrack(0,new StringBuilder());
            String[] answer=new String[result.size()];
            for(int j=0;j<result.size();j++){
                answer[j]=result.get(j);
            }
            return answer;
        }

        private void backtrack(int index,StringBuilder path){
            if(index==blocks.size()){
                result.add(path.toString());
                return;
            }

            //logic
            List<Character> list=blocks.get(index);
            for(char c:list){
                //action
                int len=path.length();
                path.append(c);

                //recurse
                backtrack(index+1,path);

                //backtrack
                path.setLength(len);
            }

        }
    }
}