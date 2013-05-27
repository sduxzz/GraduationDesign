//
//  DecodeTool.m
//  OMG
//
//  Created by juqiang on 13-5-27.
//  Copyright (c) 2013年 juqiang. All rights reserved.
//

#import "DecodeTool.h"
#import "JAGPropertyConverter.h"
#import "JSONKit.h"
@implementation DecodeTool
+(NSString *) objToJson:(id)obj{
    JAGPropertyConverter *converter = [[JAGPropertyConverter alloc] initWithOutputType:kJAGJSONOutput];
    converter.classesToConvert = [NSSet setWithObject:[obj class]];
    NSDictionary *jsonDictionary = [converter convertToDictionary:obj];
    return [[NSString alloc] initWithData:[jsonDictionary JSONData] encoding:NSUTF8StringEncoding];
}
+(id) json:(NSString *)json toObj:(id) obj{
    NSData* jsonData = [json dataUsingEncoding:NSUTF8StringEncoding];
    NSDictionary *jsonDictionary = [jsonData objectFromJSONData];
    JAGPropertyConverter *converter = [[JAGPropertyConverter alloc] init];
    [converter setPropertiesOf:obj fromDictionary:jsonDictionary];
    return obj;
}
+(id) jsontoObjArr:(NSString *)json withClass:(Class) c{
    NSData* jsonData = [json dataUsingEncoding:NSUTF8StringEncoding];
    NSArray *jsonArr=[jsonData objectFromJSONData];
    JAGPropertyConverter *converter = [[JAGPropertyConverter alloc] init];
    converter.identifyDict = ^Class (NSDictionary *dict) {
        return c;
    };
    NSArray *res=[converter composeModelFromObject:jsonArr];
    return res;
}

@end
