class Solution {
    
    public double dfs(String src,String target,double prod,HashSet<String> visited,HashMap<String,HashMap<String,Double>> map){
        double ret=-1.0;
        visited.add(src);
        if(map.get(src).containsKey(target)){
            ret=map.get(src).get(target)*prod;
        }
        else{
            for(String neighbour: map.get(src).keySet()){
                if(!visited.contains(neighbour)){
                    prod*=map.get(src).get(neighbour);
                    ret=dfs(neighbour,target,prod,visited,map);
                    if(ret!=-1){
                        break;
                    }
                    prod/=map.get(src).get(neighbour);
                }
            }
        }
        visited.remove(src);
        return ret;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
      HashMap<String,HashMap<String, Double>> map=new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String dividend=equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double res=values[i];
            
            if(!map.containsKey(dividend)){
                map.put(dividend,new HashMap<String,Double>());
            }
            
            if(!map.containsKey(divisor)){
                map.put(divisor,new HashMap<String,Double>());
            }
            map.get(dividend).put(divisor,res);
            map.get(divisor).put(dividend,1/res);
        }
        double[] res=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String dividend=queries.get(i).get(0);
            String divisor=queries.get(i).get(1);
            if(!map.containsKey(dividend) || !map.containsKey(divisor)){
                res[i]=-1.0;
            }
            else if(dividend.equals(divisor)){
                res[i]=1.0;
            }
            else{
                HashSet<String> visited=new HashSet<>();
                res[i]=dfs(dividend,divisor,1,visited,map);
            }
        }
        return res;
    }
}