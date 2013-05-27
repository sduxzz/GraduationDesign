//
//  DecodeTool.h
//  OMG
//
//  Created by juqiang on 13-5-27.
//  Copyright (c) 2013年 juqiang. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface DecodeTool : NSObject
+(NSString *) objToJson:(id) obj;
+(id) json:(NSString *)json toObj:(id) obj;
+(id) jsontoObjArr:(NSString *)json withClass:(Class) c;
@end
