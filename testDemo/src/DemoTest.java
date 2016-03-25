import com.panayotis.gnuplot.*;
import com.panayotis.gnuplot.dataset.FileDataSet;
import com.panayotis.gnuplot.layout.StripeLayout;
import com.panayotis.gnuplot.plot.AbstractPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.style.NamedPlotColor;

import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;
import com.panayotis.gnuplot.swing.JPlot;
import com.panayotis.gnuplot.terminal.PostscriptTerminal;
import com.panayotis.gnuplot.terminal.SVGTerminal;
import com.panayotis.gnuplot.utils.Debug;

import javax.swing.*;
import java.io.*;


/**
 * Created by jacka on 3/23/2016.
 */
public class DemoTest {

    public static void main(String[] args) {
        String path = null;
        if (args.length > 0)
            path = args[0];

        simple();
        simple3D();
//        defaultTerminal(path);
        //EPSTerminal(path);
        //SVGTerminal(path);
        //JPlotTerminal(path);
        //serialization(defaultTerminal(path));
        //file();

    }

    /**
     * @param gnuplotpath  The pathname of the gnuplot executable. If this parameter is
     *                     set to null, use the default path

     * @return
     */
    /* This demo code uses default terminal. Use it as reference for other javaplot arguments  */
    private static JavaPlot defaultTerminal(String gnuplotpath) {
        System.out.println("gnuplotpath = " + gnuplotpath);
        JavaPlot p = new JavaPlot(gnuplotpath); // gnuplotpath = null;
        JavaPlot.getDebugger().setLevel(Debug.VERBOSE);

        p.setTitle("Default Terminal Title 1 "); // generate four title
        p.getAxis("x").setLabel("X axis", "Arial", 20); // set lable
        p.getAxis("y").setLabel("Y axis"); //  set label, it doesn't inherent font size.

        p.getAxis("x").setBoundaries(-30, 20); // set x range
        p.setKey(JavaPlot.Key.TOP_RIGHT); //

        double[][] plot = {{1, 1.1}, {2, 2.2}, {3, 3.3}, {4, 4.3}};
        DataSetPlot s = new DataSetPlot(plot);
        p.addPlot(s);
        p.addPlot("besj0(x)*0.12e1");
        PlotStyle stl = ((AbstractPlot) p.getPlots().get(1)).getPlotStyle();
        stl.setStyle(Style.POINTS);
        stl.setLineType(NamedPlotColor.GOLDENROD);
        stl.setPointType(5);
        stl.setPointSize(8);
        p.addPlot("sin(x)");

        p.newGraph();
        p.addPlot("sin(x)");

        p.newGraph3D();
        double[][] plot3d = {{1, 1.1, 3}, {2, 2.2, 3}, {3, 3.3, 3.4}, {4, 4.3, 5}};
        p.addPlot(plot3d);

        p.newGraph3D();
        p.addPlot("sin(x)*sin(y)");

        p.setMultiTitle("Global test title");
        StripeLayout lo = new StripeLayout();
        lo.setColumns(9999);
        p.getPage().setLayout(lo);
        p.plot();

        return p;
    }

    /* This is a very simple plot to demonstrate JavaPlot graphs */
    private static void simple() {
        JavaPlot p = new JavaPlot();
        p.setTitle("Graphic Title"); // add Graphic Title
        p.addPlot("sin(x)"); // addPlot(java.lang.String function);
        p.plot(); // force to plot.
    }

    /* This is a very simple plot to demonstrate JavaPlot 3d graphs */
    private static void simple3D() {
        JavaPlot p = new JavaPlot(true);
        p.addPlot("sin(x)*y");
        p.plot();
    }



    /* This demo code creates a EPS file on home directory */
    private static JavaPlot EPSTerminal(String gnuplotpath) {
        JavaPlot p = new JavaPlot();

        PostscriptTerminal epsf = new PostscriptTerminal(System.getProperty("user.home")
                + System.getProperty("file.separator") + "output.eps");
        epsf.setColor(true);
        p.setTerminal(epsf);

        p.setTitle("Postscript Terminal Title");
        p.addPlot("sin (x)");
        p.addPlot("sin(x)*cos(x)");
        p.newGraph();
        p.addPlot("cos(x)");
        p.setTitle("Trigonometric functions -1");
        p.setMultiTitle("Trigonometric functions");
        p.plot();
        return p;
    }

    /* This demo code displays plot on screen using image terminal */
    private static JavaPlot JPlotTerminal(String gnuplotpath) {
        JPlot plot = new JPlot();
        plot.getJavaPlot().addPlot("sqrt(x)/x");
        plot.getJavaPlot().addPlot("x*sin(x)");
        plot.plot();

        JFrame f = new JFrame();
        f.getContentPane().add(plot);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        return plot.getJavaPlot();
    }

    /* This demo code displays plot on screen using SVG commands (only b&w) */
    private static JavaPlot SVGTerminal(String gnuplotpath) {
        JavaPlot p = new JavaPlot();
        JavaPlot.getDebugger().setLevel(Debug.VERBOSE);

        SVGTerminal svg = new SVGTerminal();
        p.setTerminal(svg);

        p.setTitle("SVG Terminal Title");
        p.addPlot("x+3");
        p.plot();

        try {
            JFrame f = new JFrame();
            f.getContentPane().add(svg.getPanel());
            f.pack();
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        } catch (ClassNotFoundException ex) {
            System.err.println("Error: Library SVGSalamander not properly installed?");
        }

        return p;
    }

    private static void serialization(JavaPlot p) {
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("koko.lala"));
            out.writeObject(p.getParameters());

            in = new ObjectInputStream(new FileInputStream("koko.lala"));
            JavaPlot q = new JavaPlot((GNUPlotParameters) in.readObject());
            q.plot();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    /* This is a simple plot to demonstrate file datasets */
    private static void file() {
        try {
            JavaPlot p = new JavaPlot();
            p.addPlot(new FileDataSet(new File("lala")));
            p.plot();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
