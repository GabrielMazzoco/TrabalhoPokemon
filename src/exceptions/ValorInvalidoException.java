/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.InputMismatchException;

/**
 *
 * @author mazzoco
 */
public class ValorInvalidoException extends Exception {
    private String msg;
    public ValorInvalidoException(String msg){
      super(msg);
      this.msg = msg;
    }
    
    @Override
    public String getMessage(){
      return msg;
    }
}
