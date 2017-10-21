package hey;

//GraphViz.java - a simple API to call dot from Java programs
/*$Id$*/
/*
******************************************************************************
*                                                                            *
*              (c) Copyright 2003 Laszlo Szathmary                           *
*                                                                            *
* This program is free software; you can redistribute it and/or modify it    *
* under the terms of the GNU Lesser General Public License as published by   *
* the Free Software Foundation; either version 2.1 of the License, or        *
* (at your option) any later version.                                        *
*                                                                            *
* This program is distributed in the hope that it will be useful, but        *
* WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY *
* or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public    *
* License for more details.                                                  *
*                                                                            *
* You should have received a copy of the GNU Lesser General Public License   *
* along with this program; if not, write to the Free Software Foundation,    *
* Inc., 675 Mass Ave, Cambridge, MA 02139, USA.                              *
*                                                                            *
******************************************************************************
*/

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * @author asus
 *
 */
public class GraphViz {
  /**
* The dir. where temporary files will be created.
*/
  //private static String TEMP_DIR = "/tmp"; // Linux
  private static String tEmp = "c:/temp"; // Windows

  /**
* Where is your dot program located? It will be called externally.
*/
  //private static String DOT = "/usr/bin/dot"; // Linux
  private static String dOT = "E:\\Graphviz\\bin\\dot.exe"; // Windows

  /**
* The source of the graph written in dot language.
*/
  private static StringBuilder graphGrow = new StringBuilder();
  /**
* Constructor: creates a new GraphViz object that will contain
* a graph.
*/

  /**
* Returns the graph's source description in dot language.
* @return Source of the graph in dot language.
*/
  public String getDotSource() {
    return graphGrow.toString();
  }

  /**
 *
 * @param line is a variable
 */
public void add(final String line) {
    graphGrow.append(line);
  }

  /**
* Adds a string to the graph's source (with newline).
*/
  /**
 * @param line is the variable
 */
public void addln(final String line) {
    graphGrow.append(line);
  }

  /**
* Adds a newline to the graph's source.
*/
  public void addln() {
    graphGrow.append('\n');
  }

  /**
* Returns the graph as an image in binary format.
* @param doT Source of the graph to be drawn.
* @param type Type of the output image to be produced,
* @return A byte array containing the image of the graph.
*/
  public byte[] getGraph(final String doT, final String type)  {
    File dot;
    byte[] imGraph = null;
    try {
      dot = writeDotSourceToFile(doT);
      if (dot != null)  {
          imGraph = gEt(dot, type);
        return imGraph;
      }
      return null;
    } catch (java.io.IOException ioe) {
      return null;
    }
  }

  /**
* Writes the graph's image in a file.
* @param img   A byte array containing the image of the graph.
* @param file  Name of the file to where we want to write.
* @return Success: 1, Failure: -1
*/
  public int writeGraphToFile(final byte[] img, final String file)  {
    final File toThe = new File(file);
    return writeGraphToFile(img, toThe);
  }

  /**
* Writes the graph's image in a file.
* @param img   A byte array containing the image of the graph.
* @param toThe    A File object to where we want to write.
* @return Success: 1, Failure: -1
*/
  public int writeGraphToFile(final byte[] img, final File toThe)  {
      int iMark = 1;
    try {
      final FileOutputStream fos = new FileOutputStream(toThe);
      fos.write(img);
      fos.close();
    } catch (java.io.IOException ioe)  {
      ioe.printStackTrace();
      iMark = -1;
    }
    return iMark;
  }

  /**
* It will call the external dot program, and return the image in
* binary format.
* @param dot Source of the graph (in dot language).
* @param type Type of the output image to be produced, e.g.
* @return The image of the graph in .gif format.
*/
  private byte[] gEt(final File dot, final String type)  {
    File img;
    byte[] imgStream = null;
    try {
      img = File.createTempFile("graph_", "." + type, new File(GraphViz.tEmp));
      final Runtime rtMase = Runtime.getRuntime();
      // patch by Mike Chenault
      final String[] args = {dOT, "-T" + type,
              dot.getAbsolutePath(),
              "-o", img.getAbsolutePath()};
      final  Process pMark = rtMase.exec(args);
      pMark.waitFor();
      final FileInputStream inThis = new FileInputStream(img.getAbsolutePath());
      imgStream = new byte[inThis.available()];
      inThis.read(imgStream);
      // Close it if we need to
      if (inThis != null)  {
        inThis.close();
      }
    } catch (java.io.IOException ioe)  {
      /*System.err.println("Error: in I/O processing " + GraphViz.tEmp + "\n");
      System.err.println("    or in calling external command");*/
      ioe.printStackTrace();
    } catch (java.lang.InterruptedException ie) {
      ie.printStackTrace();
    }
    return imgStream;
  }
  /**
 * @param str is a
 * @return the value is file
 * @throws java.io.IOException is a
 */
public File writeDotSourceToFile(final String str) throws java.io.IOException  {
    File temp;
    File tMark;
    try {
      temp = File.createTempFile("graph_", ".dot.tmp", new File(GraphViz.tEmp));
      final FileWriter fout = new FileWriter(temp);
      fout.write(str);
      fout.close();
      tMark = temp;
    } catch (Exception e) {
      System.err.println("Error: I/O error !");
      tMark = null;
    }
    return tMark;
  }

  /**
* Returns a string that is used to start a graph.
* @return A string to open a graph.
*/
  public String sTart()  {
    return "digraph G {";
  }

  /**
* Returns a string that is used to end a graph.
* @return A string to close a graph.
*/
  public String eNd()  {
    return "}";
  }

  /**
* Read a DOT graph from a text file.
*
* @param input Input text file containing the DOT graph
*/
  public void readSource(final String input)  {
    final StringBuilder sbIsyou = new StringBuilder();
    try {
      final FileInputStream fis = new FileInputStream(input);
      final DataInputStream dis = new DataInputStream(fis);
      final BufferedReader brd = new BufferedReader(new InputStreamReader(dis));
      String line;
      while ((line = brd.readLine()) != null) {
        sbIsyou.append(line);
      }
      dis.close();
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
    }
    this.graphGrow = sbIsyou;
  }
} // end of class GraphViz
