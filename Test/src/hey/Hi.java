/*
 * Hi.java
 *
 * Created on __DATE__, __TIME__
 */

package hey;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;
import java.awt.Desktop;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author  __USER__
 */
public class Hi extends javax.swing.JFrame {

	/** Creates new form Hi */
	public Hi() {
		initComponents();
		event();
	}

	static Hi p;
	private static String[] Color = {"red", "green", "blue", "pink", "gray"};
	private static HashMap<String,String> neiColor = new HashMap<String,String>();
	private static HashMap<String, Integer> neighbor = new HashMap<String, Integer>();//存储图中的边及其出现次数
	private static HashMap<String, Integer> numWord = new HashMap<String, Integer>();//存储不同单词的编号
	private static HashMap<Integer, String> word = new HashMap<Integer, String>();//与numWord键值相反
	private static HashMap<String, Integer> path_record = new HashMap<String, Integer>();
	private static ArrayList<HashSet<Integer>> arraylist = new ArrayList<HashSet<Integer>>();
	static int num_of_word;
	private int[][] graph;
	String filepath ="";

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(51, 204, 255));

		jTextField1.setText("\u8bf7\u8f93\u5165\u6587\u672c\u8def\u5f84");

		jButton1.setText("\u6253\u5f00\u6587\u4ef6");

		jButton2.setText("\u786e\u8ba4\u8def\u5f84");

		jButton3.setText("\u67e5\u8be2\u6865\u63a5\u8bcd");

		jButton4.setText("\u751f\u6210\u65b0\u6587\u672c");

		jButton5.setText("\u6700\u77ed\u8def\u5f84");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setText("\u968f\u673a\u6e38\u8d70");

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jTextField2.setColumns(20);
		jTextField2.setText("word1");
		jTextField2.setToolTipText("");

		jTextField3.setText("word2");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				87,
																				87,
																				87)
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				670,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				33,
																				33,
																				33)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addGap(
																												20,
																												20,
																												20)
																										.addComponent(
																												jLabel1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												603,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(
																												18,
																												18,
																												18)
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jButton4,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																318,
																																Short.MAX_VALUE)
																														.addComponent(
																																jButton5,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																318,
																																Short.MAX_VALUE)
																														.addComponent(
																																jButton3,
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																318,
																																Short.MAX_VALUE)
																														.addComponent(
																																jButton6,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																318,
																																Short.MAX_VALUE))
																										.addGap(
																												36,
																												36,
																												36))
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jTextField1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												197,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(
																												52,
																												52,
																												52)
																										.addComponent(
																												jButton1)
																										.addGap(
																												40,
																												40,
																												40)
																										.addComponent(
																												jButton2)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												325,
																												Short.MAX_VALUE)
																										.addComponent(
																												jTextField2,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												72,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(
																												45,
																												45,
																												45)
																										.addComponent(
																												jTextField3,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												66,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(
																												12,
																												12,
																												12)))))
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jTextField1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jButton1)
																		.addComponent(
																				jButton2))
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jTextField2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jTextField3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				47,
																				47,
																				47)
																		.addComponent(
																				jButton3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				65,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				103,
																				103,
																				103)
																		.addComponent(
																				jButton5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				64,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				93,
																				93,
																				93)
																		.addComponent(
																				jButton4,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				65,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				81,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButton6,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				65,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				50,
																				50,
																				50))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				590,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												79,
												javax.swing.GroupLayout.PREFERRED_SIZE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	
	public void event() {
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 String path = null;
				JFileChooser c = new JFileChooser();	
				 int i = c.showOpenDialog(null);
				 if(i==JFileChooser.APPROVE_OPTION){
					  path = c.getSelectedFile().getAbsolutePath();
					  filepath = path;
				 }
				 else
				 {
					 System.out.println("未选中文件");
				 }
				
				try {
					showDirectedGraph(neighbor, path, p);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					ImageIcon icon = new ImageIcon("E:/软件工程/实验/实验1jpg");
					icon.setImage(icon.getImage().getScaledInstance(
							jLabel1.getWidth(), jLabel1.getHeight(),
							Image.SCALE_DEFAULT));
					jLabel1.setIcon(icon);
					jLabel1.setBounds(0, 0, 105, 50);
			}
			
			
		});
		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					filepath = jTextField1.getText();
					showDirectedGraph(neighbor, filepath, p);
				
					showlabel1();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		jButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTextArea1.setText(queryBridgeWords(jTextField2.getText(),
						jTextField3.getText()));
			}

		});
		jButton4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTextArea1.setText(generateNewText(jTextArea1.getText()));
			}

		});
		jButton5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					jTextArea1.setText(calcShortestPath(jTextField2.getText(),
							jTextField3.getText()));
					showlabel1();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		jButton6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jTextArea1.setText(randomWalk());
				showlabel1();
				

			}

		});
			jTextField1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				jTextField1.setText("");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			});
			jTextField2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jTextField2.setText("");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			});
			
			jTextField3.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jTextField3.setText("");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			});
			 
	}

	public static void main(String args[]) {
		p = new Hi();
		p.setVisible(true);
	}
	
	private void showlabel1()
	{
		ImageIcon icon = new ImageIcon("E:/软件工程/实验/实验1jpg");
		icon.setImage(icon.getImage().getScaledInstance(
				jLabel1.getWidth(), jLabel1.getHeight(),
				Image.SCALE_DEFAULT));
		jLabel1.setIcon(icon);
	}
	private void graphBuild(HashMap<String, Integer> nei,
			HashMap<String, Integer> num) {
		int numsize = num.size();
		graph = new int[numsize+1][];
		for (int i = 0; i <= numsize; i++)
			graph[i] = new int[numsize+1];
		for (int i = 0; i <= numsize; i++)
			for (int j = 0; j <= numsize; j++)
				graph[i][j] = 100000000;
		Set<Entry<String, Integer>> sets = nei.entrySet();
		for (Entry<String, Integer> entry : sets) {
			String[] list = entry.getKey().split(" -> ");
			graph[num.get(list[0])][num.get(list[1])] = entry.getValue();
		}
	}

	private void wordNum(String[] list) { //给已出现单词标序号
		int count = 0;
		for (int i = 0; i < list.length; i++) {
			if (!numWord.containsKey(list[i])) {
				numWord.put(list[i], count);
				word.put(count++, list[i]);
			}
		}
		num_of_word = count;
	}

	private void mapCount(String[] list) { //边出现次数统计与记录
		String temp;
		for (int i = 0; i < list.length - 1; i++) {
			arraylist.add(new HashSet<Integer>());
		}
		for (int i = 0; i < list.length - 1; i++) {
			temp = list[i] + " -> " + list[i + 1];
			if (neighbor.containsKey(temp)) {
				Integer count = neighbor.get(temp) + 1;
				neighbor.put(temp, count);
			} else {
				neighbor.put(temp, 1);
			}
			arraylist.get(numWord.get(list[i])).add(numWord.get(list[i + 1]));
			path_record.put(temp, 0);
		}
	}

	private String readFile(String filename) throws IOException { //读文件
		BufferedReader file = new BufferedReader(new FileReader(filename));
		String text = "";
		String line = file.readLine();
		while (line != null) {
			text += line;
			line = file.readLine();
		}
		file.close();
		return text;
	}

	private void showDirectedGraph(HashMap<String, Integer> list, String path,
			Hi p) throws IOException//展示有向图，并存为.jpg
	{
		String text = p.readFile(path);
		text = text.replaceAll("[^a-zA-Z]", " ");
		text = text.toLowerCase();
		String[] wordlist = text.split("\\s+");
		neighbor.clear();
		numWord.clear();
		p.wordNum(wordlist);
		p.mapCount(wordlist);
		p.graphBuild(neighbor, numWord);
		//p.showDirectedGraph(neighbor);

		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		Set<Entry<String, Integer>> sets = list.entrySet();
		for (Entry<String, Integer> entry : sets) {
			String t = entry.getKey();
        	if(neiColor.containsKey(t))
        		gv.addln(t+" [ label = " + "\"" + entry.getValue().toString()+ "\" " + neiColor.get(t) +" ];" );
        	else
        		gv.addln(t+" [ label = " + "\"" + entry.getValue().toString()+ "\"" +" ];" );
		}
		gv.addln(gv.end_graph());
		System.out.println(gv.getDotSource());
		//System.out.println("看见了吗"); 
		String type = "jpg";
		File out = new File("E:/软件工程/实验/实验1" + type);
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), out);
	}

	private String queryBridgeWords(String word1, String word2) {
		String bridgewords = "不存在";
		if (!numWord.containsKey(word1))
		{
			bridgewords += (" " + word1);
		}
		if(!numWord.containsKey(word2))
		{
			bridgewords += (" " + word2);
		}
			
		if (numWord.containsKey(word1) && numWord.containsKey(word2)) {
			bridgewords = "";
			int word1num = numWord.get(word1);
			int word2num = numWord.get(word2);
			for (int i = 0; i < numWord.size(); i++) {
				int num = graph[word1num][i] + graph[i][word2num];
				if (i != word1num && i != word2num && num >= 2
						&& num < 100000000) {
					//Set<Entry<String, Integer>> sets = numWord.entrySet();  
					//for(Entry<String, Integer> entry : sets) {  
					//if(numWord.get(entry.getKey()) == i){
					//bridgewords += (entry.getKey() +" ");
					//break;
					//}
					//} 
					bridgewords += (word.get(i) + " ");
				}
			}
			if (bridgewords == "")
				return "不存在桥接词";
		}
		
		return bridgewords;
	} //查询桥接词

	private String generateNewText(String inputText) {
		int j;
		String newText = "", bridge = "";
		String[] text = inputText.split("\\s+");
		for (int i = 0; i < text.length - 1; i++) {
			
			bridge = queryBridgeWords(text[i], text[i + 1]);
			if (bridge != "不存在桥接词") {
				String[] bw = bridge.split("\\s+");
				int length = bw.length;
				Random r = new Random();
				j = r.nextInt(length);
				newText += (text[i] + " " + bw[j] + " ");
			} else {
				newText += (text[i] + " ");
			}
		}
		return (newText + text[text.length - 1]);
	}//根据bridge word生成新文本

	private void mapColor(String [] list,int count){  //边出现次数统计与记录
    	String temp;
    	for(int i=list.length-1;i>0;i--){
    		temp = list[i]+" -> "+list[i-1];
    		if(!neiColor.containsKey(temp)){
    			neiColor.put(temp, "color = "+Color[count]);
    		}
    	}
    }
	private String calcShortestPath(String word1, String word2) throws IOException {
		String Path = "不存在";
		if (!numWord.containsKey(word1))
		{
			Path += (" " + word1);
		}
		if((!numWord.containsKey(word2)))
		{
			boolean x;
			if(!word2.equals(""))
			    Path += (" " + word2);
		}
		
		if(numWord.containsKey(word1)&&(numWord.containsKey(word2) || word2.equals(""))){
			int n = numWord.size(), v = numWord.get(word1);
			String rePath = "";
			Path = "";
			boolean[] flag = new boolean[n+1];
			int[] dis = new int[n+1];
			int[] path = new int[n+1];
			for (int i = 0; i < n; i++) {
				dis[i] = graph[v][i];
				if (dis[i] == 100000000)
					path[i] = n;
				else
					path[i] = v;
				flag[i] = false;
			}
			flag[v] = true;
			for (int i = 1; i < n; i++) {
				int min = 100000000;
				int u = n;
				for (int j = 0; j < n; j++) {
					if (dis[j] < min && !flag[j]) {
						min = dis[j];
						u = j;
					}
				}
				flag[u] = true;
				for (int j = 0; j < n; j++) {
					if (!flag[j] && min + graph[u][j] < dis[j]) {
						dis[j] = min + graph[u][j];
						path[j] = u;
					}
				}
			}
			if (numWord.containsKey(word2)) {
				int e = numWord.get(word2);
				int f = e;
				while (path[f] != n) {
					rePath += (word.get(f) + " ");
					f = path[f];
				}
				if (rePath != "") {
					rePath += word.get(f);
					String[] text = rePath.split(" ");
					neiColor.clear();
	   				mapColor(text,0);
	   				showDirectedGraph(neighbor,filepath,p);
					Path += word1;
					for (int i = text.length - 2; i >= 0; i--) {
						Path += ("->" + text[i]);
					}
				}
			}
			else{
				for(int i = 0;i < n; i++){
					String X="";
					int f = i;
					while (path[f] != n) {
						X += (word.get(f) + " ");
						f = path[f];
					}
					if (X != "") {
						X += word.get(f);
						String[] text = X.split(" ");
						rePath += word1;
						for (int j = text.length - 2; j >= 0; j--) {
							rePath += ("->" + text[j]);
						}
						rePath += "\n";
					}
				}
				Path = rePath;
			}
		}
		if(Path == "")
			Path = "不可达";
		return Path;
		
	} //计算两个单词之间的最短路径

	private static String randomWalk() {
		HashMap<String, Integer> path_temp = (HashMap<String, Integer>) path_record.clone();
		neiColor.clear();
		Random r1 = new Random();
		Random r2 = new Random();
		System.out.println(num_of_word);
		int begin =r1.nextInt(num_of_word);
		
		StringBuffer random_path = new StringBuffer();
		Integer[] nextarray = arraylist.get(begin).toArray(
				new Integer[arraylist.get(begin).size()]);
		
		if (nextarray.length == 0) {
			System.out.println("后续无节点1");
			return null;
		}
		int nextword = r2.nextInt(nextarray.length);
		
		//System.out.println("0:"+nextarray[0]+"    1:"+nextarray[1]+"   2:"+nextarray[2]);
		System.out.println("nextarray.length:" + nextarray.length + "begin:"
				+ begin + "next" + nextarray[nextword]);
		String a = new String();
		String b = new String();
		a = word.get(begin);
		b = word.get(nextarray[nextword]);
		random_path.append(a);
		while (nextarray.length != 0 && path_temp.get(a + " -> " + b) == 0) {
			random_path.append(" -> " + b);
			path_temp.put(word.get(begin) + " -> "
					+ word.get(nextarray[nextword]), 1);
			begin = nextarray[nextword];
			nextarray = arraylist.get(begin).toArray(
					new Integer[arraylist.get(begin).size()]);
			System.out.println("nextarray.length:" + nextarray.length
					+ "begin:" + begin);
			if (nextarray.length == 0) {
				/*path_temp.put(word.get(begin) + " -> "
						+ word.get(nextarray[nextword]), 1);*/
				System.out.println(random_path.toString());
				System.out.println("后续无节点");
				GraphViz gv = new GraphViz();
				gv.addln(gv.start_graph());
				Set<Entry<String, Integer>> sets = neighbor.entrySet();
				for (Entry<String, Integer> entry : sets) {
					String t = entry.getKey();
		        	if(path_temp.get(t)==1)
		        		gv.addln(t+" [ label = " + "\"" + entry.getValue().toString()+ "\" " + " color = red" +" ];" );
		        	else
		        		gv.addln(t+" [ label = " + "\"" + entry.getValue().toString()+ "\"" +" ];" );
				}
				gv.addln(gv.end_graph());
				System.out.println(gv.getDotSource());
				String type = "jpg";
				File out = new File("E:/软件工程/实验/实验1" + type);
				gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), out);
				
				return random_path.toString();
			}
			nextword = r2.nextInt(nextarray.length);
			a = word.get(begin);
			b = word.get(nextarray[nextword]);

		}
		System.out.println(random_path.toString() + " -> " + b);
		random_path = random_path.append(" -> " + b);
		
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		Set<Entry<String, Integer>> sets = neighbor.entrySet();
		for (Entry<String, Integer> entry : sets) {
			String t = entry.getKey();
        	if(path_temp.get(t)==1)
        		gv.addln(t+" [ label = " + "\"" + entry.getValue().toString()+ "\" " + " color = red" +" ];" );
        	else
        		gv.addln(t+" [ label = " + "\"" + entry.getValue().toString()+ "\"" +" ];" );
		}
		gv.addln(gv.end_graph());
		System.out.println(gv.getDotSource());
 
		String type = "jpg";
		File out = new File("E:/软件工程/实验/实验1" + type);
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), out);
		File pathfile = new File("E:/软件工程/实验/实验1/path.txt");
		FileWriter fw = null;
        BufferedWriter writer = null;
        try {
            fw = new FileWriter(pathfile);
            writer = new BufferedWriter(fw);
          
                writer.write(random_path.toString());
                writer.newLine();//换行
           
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                writer.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
    
		return random_path.toString();
	} //随机游走
	//GEN-BEGIN:variables
	// Variables declaration - do not modify

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	// End of variables declaration//GEN-END:variables

}