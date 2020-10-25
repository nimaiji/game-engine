/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
#include "game.h"
/* Header for class xo_UiConnection */

#ifndef _Included_xo_UiConnection
#define _Included_xo_UiConnection
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     xo_UiConnection
 * Method:    start
 * Signature: (IILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Ljava/lang/Boolean;
 */
JNIEXPORT jboolean JNICALL Java_xo_UiConnection_start
  (JNIEnv *, jobject, jint, jint, jstring, jstring, jobject, jobject);

/*
 * Class:     xo_UiConnection
 * Method:    botMove
 * Signature: ()Ljava/util/ArrayList;
 */
JNIEXPORT jint JNICALL Java_xo_UiConnection_botMove
  (JNIEnv *, jobject);

/*
 * Class:     xo_UiConnection
 * Method:    end
 * Signature: ()Ljava/lang/Boolean;
 */
JNIEXPORT jint JNICALL Java_xo_UiConnection_end
  (JNIEnv *, jobject);

/*
 * Class:     xo_UiConnection
 * Method:    move
 * Signature: (II)Ljava/lang/Boolean;
 */
JNIEXPORT jboolean JNICALL Java_xo_UiConnection_move
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     xo_UiConnection
 * Method:    isOver
 * Signature: ()Ljava/lang/Boolean;
 */
JNIEXPORT jboolean JNICALL Java_xo_UiConnection_isOver
  (JNIEnv *, jobject);



#ifdef __cplusplus
}
#endif
#endif
