package com.flyjun.autoview.util;

/**
 * 适配支持的属性值
 * @author Flyjun
 *
 */
public class ViewAttributeSet {
	
	public float width;
    public float height;
	
	public float textSize;

	public float margin;
	public float marginLeft;
	public float marginRight;
	public float marginTop;
	public float marginBottom;

	public float padding;
	public float paddingLeft;
	public float paddingRight;
	public float paddingTop;
	public float paddingBottom;

	public float drawablePadding;

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getTextSize() {
		return textSize;
	}

	public void setTextSize(float textSize) {
		this.textSize = textSize;
	}

	public float getMargin() {
		return margin;
	}

	public void setMargin(float margin) {
		this.margin = margin;
	}

	public float getMarginLeft() {
		return marginLeft;
	}

	public void setMarginLeft(float marginLeft) {
		this.marginLeft = marginLeft;
	}

	public float getMarginRight() {
		return marginRight;
	}

	public void setMarginRight(float marginRight) {
		this.marginRight = marginRight;
	}

	public float getMarginTop() {
		return marginTop;
	}

	public void setMarginTop(float marginTop) {
		this.marginTop = marginTop;
	}

	public float getMarginBottom() {
		return marginBottom;
	}

	public void setMarginBottom(float marginBottom) {
		this.marginBottom = marginBottom;
	}

	public float getPadding() {
		return padding;
	}

	public void setPadding(float padding) {
		this.padding = padding;
	}

	public float getPaddingLeft() {
		return paddingLeft;
	}

	public void setPaddingLeft(float paddingLeft) {
		this.paddingLeft = paddingLeft;
	}

	public float getPaddingRight() {
		return paddingRight;
	}

	public void setPaddingRight(float paddingRight) {
		this.paddingRight = paddingRight;
	}

	public float getPaddingTop() {
		return paddingTop;
	}

	public void setPaddingTop(float paddingTop) {
		this.paddingTop = paddingTop;
	}

	public float getPaddingBottom() {
		return paddingBottom;
	}

	public void setPaddingBottom(float paddingBottom) {
		this.paddingBottom = paddingBottom;
	}

	public float getDrawablePadding() {
		return drawablePadding;
	}

	public void setDrawablePadding(float drawablePadding) {
		this.drawablePadding = drawablePadding;
	}

	@Override
	public String toString() {
		return "ViewAttributeSet{" +
				"width=" + width +
				", height=" + height +
				", textSize=" + textSize +
				", margin=" + margin +
				", marginLeft=" + marginLeft +
				", marginRight=" + marginRight +
				", marginTop=" + marginTop +
				", marginBottom=" + marginBottom +
				", padding=" + padding +
				", paddingLeft=" + paddingLeft +
				", paddingRight=" + paddingRight +
				", paddingTop=" + paddingTop +
				", paddingBottom=" + paddingBottom +
				", drawablePadding=" + drawablePadding +
				'}';
	}
}
