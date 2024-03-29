/*
 * The MIT License
 *
 * Copyright 2022 SchumakerTeam.
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
package com.schumakerteam.tetris.core;

import com.schumakerteam.tetris.gfx.Board;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Hudson Schumaker
 */
public class Game extends JFrame {

    private final JLabel statusbar;
    private Image icon;
    
    public Game(Image icon) {
        this.icon = icon;
        this.setIconImage(icon);
        
        this.statusbar = new JLabel("0");
        this.add(this.statusbar, "South");
        Board board = new Board(this);
        this.add(board);
        this.setResizable(false);
        this.setSize(200, 400);
        this.setTitle("STeam - Tetris");
        this.setDefaultCloseOperation(3);
           
        board.start();
    }
    
    public JLabel getStatusBar() {
        return this.statusbar;
    }
}