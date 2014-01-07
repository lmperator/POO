/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package po.pkg666;

import java.io.Serializable;

/**
 *
 * @author Artur
 */
public class Result implements Serializable{
    public long time;
    public int points;
    
    public Result(){
        time = 20000;
        points = 106;
    }
}
