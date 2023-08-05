//
//  JavaWOTypeWriter.java
//  WSDL2JavaWO
//
//  Created by Victor Tsang on Sun Jan 19 2003.
//  Copyright (c) 2003 Victor Tsang. All rights reserved.
//

package com.villeo.app.wsdl2javawo;

import java.util.*;
import javax.wsdl.*;
import org.apache.axis.wsdl.gen.*;
import org.apache.axis.wsdl.*;
import org.apache.axis.wsdl.toJava.*;
import org.apache.axis.wsdl.symbolTable.*;

public class JavaWOTypeWriter extends JavaTypeWriter
{
  public JavaWOTypeWriter(Emitter emitter,TypeEntry typeEntry,SymbolTable symbolTable)
  {
    super(emitter,typeEntry,symbolTable);
  }

  protected JavaWriter getBeanWriter(Emitter emitter,TypeEntry type,Vector element,TypeEntry baseType,Vector attr)
  {
    JavaWriter jw=super.getBeanWriter(emitter,type,element,baseType,attr);

    if(jw instanceof JavaBeanWriter)
    {
      JavaWriter helper=getBeanHelperWriter(emitter,type,element,baseType,attr);
      return new KVCBeanWriter(emitter,type,element,baseType,attr,helper);
    }
    else
      return jw;
  }

  
}
