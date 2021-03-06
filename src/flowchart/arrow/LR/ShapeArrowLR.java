/*
 * Copyright (c) 2015 Instituto Politecnico de Tomar. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 */
//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2015   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package flowchart.arrow.LR;

import i18n.Fi18N;
import flowchart.shape.BorderFlowChart;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Polygon;

/**
 *
 * @author ZULU
 */
public class ShapeArrowLR extends BorderFlowChart {

    static String VALUE_TRUE = Fi18N.get("STRING.arrow.true");

    /**
     * Creates a line border with the specified color, thickness, and corner
     * shape.
     *
     * @param color the color of the border
     */
    public ShapeArrowLR(Color color) {
        super(color);
    }

    /**
     * Paints the border for the specified component with the specified position
     * and size.
     *
     * @param c the component for which this border is being painted
     * @param g the paint graphics
     * @param x the x position of the painted border
     * @param y the y position of the painted border
     * @param width the width of the painted border
     * @param fillColor
     * @param height the height of the painted border
     */
    @Override
    public void paint(Graphics g, int x, int y, int width, int height, Color fillColor) {     

        int S = getBorderSize() / 2+1;
        Polygon p;
        if (shape.parent.getY() < shape.next.getY()) {
            p = getTopBottom(x, y, x + width, y + height, S);
        }else{
            p= getBottomTop(x, y, x + width, y + height, S);
        }
        g.setColor(fillColor);
        g.fillPolygon(p);
        g.setColor(Color.BLACK);
        g.drawPolygon(p);

//    }
    }

    private Polygon getTopBottom(int x1, int y1, int x2, int y2, int S) {
        Polygon p = new Polygon();
        int xm = 2 * (x1 + x2) / 3 < 4 ? 4 : 2 * (x1 + x2) / 3;

        p.addPoint(x2, y1);
        p.addPoint(x2, y1 + S);
        p.addPoint(xm, y1 + S);
        p.addPoint(xm, y2 - 1 * S);
        //---------------SETA
        p.addPoint(x1 + 2 * S, y2 - 1 * S);
        p.addPoint(x1 + 3 * S, y2);
        p.addPoint(x1, (int) (y2 - 1.5 * S));
        p.addPoint(x1 + 3 * S, y2 - 3 * S);
        p.addPoint(x1 + 2 * S, y2 - 2 * S);
        //----------------ARROW
//        p.addPoint(x1, y2 - 1 * S);
//        p.addPoint(x1, y2 - 2 * S);
        p.addPoint(xm - S, y2 - 2 * S);
        p.addPoint(xm - S, y1);
        p.addPoint(p.xpoints[0], p.ypoints[0]);  //fechar
        return p;
    }
    
     private Polygon getBottomTop(int x1, int y1, int x2, int y2, int S) {
        Polygon p = new Polygon();
        int xm = 2 * (x1 + x2) / 3 < 4 ? 4 : 2 * (x1 + x2) / 3;

        p.addPoint(x2, y2);
       p.addPoint(x2-xm-S, y2);
       
       p.addPoint(x2-xm-S, y1+3*S);
       
       //----------------------- ARROW
       p.addPoint(x1+2*S, y1+3*S);
       p.addPoint(x1+3*S, y1+4*S);
       p.addPoint(x1, (int)(y1+2.5*S));
       p.addPoint(x1+3*S, y1+S);
       p.addPoint(x1+2*S, y1+2*S);
       
       //----------------------- ARROW
       p.addPoint(x2-xm, y1+2*S);
       p.addPoint(x2-xm, y2-S);
       p.addPoint(x2, y2-S);
                
        
        p.addPoint(p.xpoints[0], p.ypoints[0]);  //fechar
        return p;
    }

    /**
     * Reinitialize the insets parameter with this Border's current Insets.
     *
     * @param c the component for which this border insets value applies
     * @param insets the object to be reinitialized
     */
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.set(getThickness(), getThickness(), getThickness(), getThickness());
        return insets;
    }

//    public Shape createArrowShape(int x, int y, double ang) {
//        Polygon pts = new Polygon();
//        int S = getBorderSize()*2;
//        pts.addPoint(0, 0);        
//        pts.addPoint(3 * S, (int)(1.5* S));
//        pts.addPoint(0, 3*S);
//        pts.addPoint(S, 2*S);
//        pts.addPoint(0, 2*S);
//        pts.addPoint(0, S);
//        pts.addPoint(S, S);
//        pts.addPoint(0, 0);
//
//        AffineTransform transform = new AffineTransform();
//        transform.translate(1.5 * S, 1.5*S);
//        transform.rotate(ang);
//        transform.translate(-1.5 * S, -1.5*S);
//        transform.translate(x, y);
//        return transform.createTransformedShape(pts);
//    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 201509071215L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2015  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
