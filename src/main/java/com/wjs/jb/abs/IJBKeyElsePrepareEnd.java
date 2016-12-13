/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.IJBAppend;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public abstract class IJBKeyElsePrepareEnd<Parent extends IJBAppend> extends IJBAppend {

	/***
	 * Parent is IJBObject
	 */
	public abstract Parent eif();

}
