package com.quane.zkoss;

import java.io.IOException;

import org.zkoss.lang.Objects;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.impl.LabelImageElement;

/**
 * A breadcrumb represents a single step on the trail back home.
 *
 * @author Sean Connolly
 */
public class TrailItem extends LabelImageElement {

	private static final String NORMAL = "normal";
	private static final String REVERSE = "reverse";

	private String dir = NORMAL;
	private boolean disabled = false;

	/**
	 * Returns the direction.<br/>
	 * Default: "normal".
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * Sets the layout direction; the location of the image to the label.<br/>
	 * Valid values are {@code normal} and {@code reverse}.
	 *
	 * @param dir
	 *            either "normal" or "reverse".
	 * @throws WrongValueException
	 *             if an invalid direction is set
	 */
	public void setDir(String dir) throws WrongValueException {
		if (!isValidDir(dir)) {
			throw new WrongValueException(dir);
		}
		if (!Objects.equals(this.dir, dir)) {
			this.dir = dir;
			smartUpdateDir();
		}
	}

	private boolean isValidDir(String dir) {
		return NORMAL.equals(dir) || REVERSE.equals(dir);
	}

	private void smartUpdateDir() {
		smartUpdate("dir", dir);
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void renderProperties(ContentRenderer renderer)
			throws IOException {
		super.renderProperties(renderer);
		if (!NORMAL.equals(dir)) {
			render(renderer, "dir", dir);
		}
		if (disabled) {
			render(renderer, "disabled", disabled);
		}
	}

}
