/*
 * The MIT License
 *
 * Copyright 2022 schumaker.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.schumakerteam.tetris.run;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Hudson Schumaker
 */
public class Splash extends JFrame {
    private Image icon;
    
    public Splash() {
        JPanel panel = new JPanel();
        this.loadIcon();
        
        URL url = getClass().getResource("logo.png");
        ImageIcon logo = new ImageIcon(url);
        panel.add(new JLabel(logo));
        this.add(panel);
        this.setResizable(false);
        this.setSize(400, 107);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
    }
    
    private void loadIcon() {
        URL url = getClass().getResource("avatar.png");
        try {
            BufferedImage source = ImageIO.read(url);
            
            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
            Image image = gc.createCompatibleImage(source.getWidth(), source.getHeight(), Transparency.TRANSLUCENT);
            
            image.getGraphics().drawImage(source, 0, 0, null);
            image.setAccelerationPriority(1.0f);
            this.setIconImage(image);
            this.icon = image;
        } catch (IOException ex) {}
    }
    
    public Image getIcon() {
        return icon;
    }
}
