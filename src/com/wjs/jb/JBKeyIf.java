package com.wjs.jb;
///**
// *
// */
//package org.jb;
//
//import org.jb.abs.IJBArray;
//import org.jb.abs.IJBFilter;
//import org.jb.abs.IJBKeyIf;
//import org.jb.abs.IJBObject;
//
///**
// * @author zju_wjf
// * @date 2016Äê12ÔÂ11ÈÕ
// */
//public class JBKeyIf<ParentType extends IJBAppend> extends IJBAppend implements IJBKeyIf<ParentType>, JBConstants {
//	private final AbsJB jb;
//	private final ParentType parent;
//	private final String key;
//	private final boolean parentReality;
//	private final boolean brotherReality;
//	private final boolean selfReality;
//
//	JBKeyIf(AbsJB jb, ParentType parent, String key, boolean parentReality, boolean brotherReality, boolean selfReality) {
//		super();
//		this.jb = jb;
//		this.parent = parent;
//		this.key = key;
//		this.parentReality = parentReality;
//		this.brotherReality = brotherReality;
////		this.selfReality = selfReality;
//	}
//
//	@Override
//	public ParentType v(Object value) {
//		if (reality() && parent != null) {
//			parent.append(key, value);
//		}
//		return parent;
//	}
//
//	@Override
//	public JBObject<ParentType> o() {
//		return null;
//	}
//
//	@Override
//	public IJBObject<ParentType> o(IJBFilter filter) {
//		return null;
//	}
//
//	@Override
//	public IJBArray<ParentType> a() {
//		return null;
//	}
//
//	@Override
//	public IJBArray<ParentType> a(IJBFilter filter) {
//		return null;
//	}
//
//	@Override
//	public IJBKeyIf<? extends IJBKeyIf<ParentType>> if_(boolean _if) {
//		return null;
//	}
//
//	@Override
//	public IJBKeyIf<? extends IJBKeyIf<ParentType>> if_(Object _if) {
//		return null;
//	}
//
//	@Override
//	void append(String key, Object value) {
//
//	}
//
//	@Override
//	boolean reality() {
//		return parentReality && (!brotherReality) && selfReality;
//	}
//}
