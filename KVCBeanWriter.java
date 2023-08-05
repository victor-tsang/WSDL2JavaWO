//
//  KVCBeanWriter.java
//  WSDL2JavaWO
//
//  Created by Victor Tsang on Sun Jan 19 2003.
//  Copyright (c) 2003 Victor Tsang. All rights reserved.
//

package com.villeo.app.wsdl2javawo;

import java.util.*;
import java.io.*;
import javax.wsdl.*;
import org.apache.axis.wsdl.WSDL2Java;
import org.apache.axis.wsdl.gen.*;
import org.apache.axis.wsdl.*;
import org.apache.axis.wsdl.toJava.*;
import org.apache.axis.wsdl.symbolTable.*;

public class KVCBeanWriter extends JavaBeanWriter
{
  protected KVCBeanWriter(Emitter e,TypeEntry t,Vector ele,TypeEntry extT,Vector attr,JavaWriter helper)
  {
    super(e,t,ele,extT,attr,helper);
  }

  protected String getImplementsText()
  {
    String s=super.getImplementsText();
    return s+", com.webobjects.foundation.NSKeyValueCoding ";
  }

  protected void writeFileFooter(PrintWriter pw)throws IOException
  {
    StringBuffer sb=new StringBuffer(80);

    sb.append("  // NSKeyValueCoding support ======================\n")
      .append("  public static boolean canAccessFieldsDirectly()\n")
      .append("  {\n")
      .append("    return false;\n")
      .append("  }\n")
      .append("  \n")
      .append("  public Object valueForKey(String key)\n")
      .append("  {\n")
      .append("    return com.webobjects.foundation.NSKeyValueCoding.DefaultImplementation.valueForKey(this,key);\n")
      .append("  }\n")
      .append("  \n")
      .append("  public void takeValueForKey(Object value,String key)\n")
      .append("  {\n")
      .append("    com.webobjects.foundation.NSKeyValueCoding.DefaultImplementation.takeValueForKey(this,value,key);\n")
      .append("  }\n")
      .append("  \n")
      .append("}\n\n//EOF\n\n");

    pw.println(sb.toString());
  }
}
