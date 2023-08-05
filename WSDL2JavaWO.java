//
//  WSDL2JavaWO.java
//  WSDL2JavaWO
//
//  Created by Victor Tsang on Sun Jan 19 2003.
//  Copyright (c) 2003 Victor Tsang. All rights reserved.
//

package com.villeo.app.wsdl2javawo;

import java.util.*;
import com.webobjects.foundation.*;

import org.apache.axis.wsdl.toJava.Emitter;

public class WSDL2JavaWO
{
  public static void main (String args[])
  {
    if(args.length<3)
    {
      NSLog.out.appendln("bad arguments.\nUsage: WSDL2JavaWO [package name] [output path] [WSDL URL]");
      return;
    }

    String pkg=args[0];
    String outputPath=args[1];
    String wsdl=args[2];
    
    NSLog.out.appendln("pkg="+pkg+",out="+outputPath+",wsdl="+wsdl);

    Emitter emitter=new Emitter();
    JavaWOGeneratorFactory factory=new JavaWOGeneratorFactory(emitter);
    
    emitter.setPackageName(pkg);
    emitter.setOutputDir(outputPath);
    emitter.setFactory(factory);
    try
    {
      emitter.run(wsdl);
      factory.makeup();
    }
    catch(Exception e)
    {
      NSLog.out.appendln("Exception: "+e.getMessage());
      return;
    }
  }
}
