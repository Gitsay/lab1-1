package lab1;

import java.io.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
public class Proba
{
    private static HashMap<String,Integer> neighbor = new HashMap<String,Integer>();//存储图中的边及其出现次数
    private static HashMap<String,Integer> numWord = new HashMap<String,Integer>();//存储不同单词的编号
    private static HashMap<Integer,String> word = new HashMap<Integer,String>();//与numWord键值相反
    private int [][] graph;
    public static void main(String[] args) throws IOException
    {
    	Proba p = new Proba();
        System.out.println("请输入文件路径（。txt）：");
        Scanner s = new Scanner(System.in);
        String name = s.next();
        String text = p.readFile(name);
        text = text.replaceAll("[^a-zA-Z]", " ");
        text = text.toLowerCase();
        String [] wordlist = text.split("\\s+");
        p.wordNum(wordlist);
        p.mapCount(wordlist);
        p.graphBuild(neighbor, numWord); 
        p.showDirectedGraph(neighbor);
        System.out.println("图生成完毕，存于电脑上");
        //System.out.println(p.queryBridgeWords("explore" ,"new"));
       // System.out.println("输入要插入桥接词的文本：");
        //String inputtext = s.nextLine();
        //inputtext = s.nextLine();
        //System.out.println(inputtext);
        //System.out.println("新文本：");
        //System.out.println(p.generateNewText(inputtext.toLowerCase()));
        System.out.println(p.calcShortestPath("to","and"));
        
        s.close();
    }

    private void graphBuild(HashMap<String,Integer> nei,HashMap<String,Integer> num){
    	int numsize = num.size();
    	graph = new int [numsize][];
    	for(int i=0;i<numsize;i++)
    		graph[i] = new int[numsize];
    	for(int i=0;i<numsize;i++)
    		for(int j=0;j<numsize;j++)
    			graph[i][j] = 100000000;
    	Set<Entry<String, Integer>> sets = nei.entrySet();  
        for(Entry<String, Integer> entry : sets) {  
           String []list = entry.getKey().split(" -> ");
           graph[num.get(list[0])][num.get(list[1])] = entry.getValue();
        }  
    }
    private void wordNum(String [] list){  //给已出现单词标序号
    	int count = 0;
    	for(int i=0;i<list.length;i++){
    		if(!numWord.containsKey(list[i])){
    			numWord.put(list[i], count);
    			word.put(count++, list[i]);
    		}
    	}
    }
    private void mapCount(String [] list){  //边出现次数统计与记录
    	String temp;
    	for(int i=0;i<list.length-1;i++){
    		temp = list[i]+" -> "+list[i+1];
    		if(neighbor.containsKey(temp)){
    			Integer count = neighbor.get(temp) + 1;
    			neighbor.put(temp, count);
    		}
    		else{
    			neighbor.put(temp, 1);
    		}
    	}
    }
    private String readFile(String filename) throws IOException{  //读文件
    	BufferedReader file = new BufferedReader(new FileReader(filename));
    	String text = "";
    	String line = file.readLine();
    	while(line != null){
    		text += line;
    		line = file.readLine();
    	} 
    	file.close();
    	return text;
    }
    private void showDirectedGraph(HashMap<String,Integer> list)//展示有向图，并存为.jpg
    {
    	GraphViz gv = new GraphViz();
    	gv.addln(gv.start_graph());
    	Set<Entry<String, Integer>> sets = list.entrySet();  
        for(Entry<String, Integer> entry : sets) {  
            gv.addln(entry.getKey()+" [ label = " + "\"" + entry.getValue().toString()+ "\"" +" ];" );
        }  
    	gv.addln(gv.end_graph());
    	System.out.println(gv.getDotSource());      
    	String type = "jpg";
    	File out = new File("D:/360Downloads/out." + type);
    	gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
    }
   
    private String queryBridgeWords(String word1, String word2) {
    	String bridgewords = "";
    	if(numWord.containsKey(word1) && numWord.containsKey(word2)){
    		int word1num = numWord.get(word1);
    		int word2num = numWord.get(word2);
    		for(int i=0;i<numWord.size();i++){
    			int num = graph[word1num][i] + graph[i][word2num];
    			if(i!=word1num && i!=word2num && num>=2 && num<100000000){
    				//Set<Entry<String, Integer>> sets = numWord.entrySet();  
    				//for(Entry<String, Integer> entry : sets) {  
    	        		//if(numWord.get(entry.getKey()) == i){
    	        			//bridgewords += (entry.getKey() +" ");
    	        			//break;
    	        		//}
    	        	//} 
    				bridgewords += (word.get(i) +" ");
    			}
    		}
    	}
    	return bridgewords;
    } //查询桥接词
    private String generateNewText(String inputText) {
    	String newText = "" ,bridge = "";
    	String []text = inputText.split("\\s+");
    	for(int i=0;i<text.length-1;i++){
    		bridge = queryBridgeWords(text[i],text[i+1]);
    		if(bridge != ""){
    			String []bw = bridge.split("\\s+");
    			newText += (text[i]+" "+bw[0]+" ");
    		}
    		else{
    			newText += (text[i]+" ");
    		}
    	}
    	return (newText + text[text.length-1]);
    }//根据bridge word生成新文本
    private String calcShortestPath(String word1, String word2) {
    	int n = numWord.size(),v = numWord.get(word1);
    	String Path = "";
    	boolean [] flag = new boolean[n];
    	int[] dis = new int[n];
    	int[] path = new int[n];
    	for (int i = 0; i < n; i++) {
    		dis[i] = graph[v][i];
    		if (dis[i] == 100000000)
    			path[i] = -1;
    		else
    			path[i] = v;
    		flag[i] = false;
    	}
    	flag[v] = true;
    	for (int i = 1; i<n; i++) {
    		int min = 100000000;
    		int u=-1;
    		for (int j = 0; j < n; j++) {
    			if (dis[j]<min && !flag[j]) {
    				min = dis[j];
    				u = j;
    			}
    		}
    		flag[u] = true;
    		for (int j = 0; j < n; j++) {
    			if (!flag[j] && min + graph[u][j]<dis[j]) {
    				dis[j] = min + graph[u][j];
    				path[j] = u;
    			}
    		}
    	}
    	if(numWord.containsKey(word2)){
    		int e = numWord.get(word2);
    		int f = e;
    		String rePath = "";
    		while (path[f] != -1) {
   				rePath += (word.get(f)+" ");
   				f = path[f];    				
   			}
   			if(rePath!=""){
   				rePath += word.get(f);
   				String []text = rePath.split(" ");
   				Path += word1;
   				for(int i = text.length-2;i>=0;i--){
   					Path += ("->" + text[i]);
   				}
   			}
    	}
    	return Path;
    } //计算两个单词之间的最短路径
    private String randomWalk() {
    	return null;
    } //随机游走
}