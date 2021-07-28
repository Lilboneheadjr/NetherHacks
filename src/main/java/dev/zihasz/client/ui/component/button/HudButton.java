package dev.zihasz.client.ui.component.button;

import dev.zihasz.client.feature.hud.HudComponent;
import dev.zihasz.client.feature.traits.IClosable;
import dev.zihasz.client.utils.render.Colors;
import dev.zihasz.client.utils.render.Renderer2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HudButton extends Button implements IClosable {

	protected final HudComponent component;

	private boolean open = true;

	private final List<SettingButton> settingButtons = new ArrayList<>();

	public HudButton(HudComponent component, Rectangle button, Colors colors) {
		super(button, colors);
		this.component = component;
	}

	public void render(Point mouse) {
		Renderer2D.drawRectangle(button, component.enabled ? colors.fore : colors.back);
	}

	public void onMouseDown(Point mouse, int mb) {

	}

	public void onMouseUp(Point mouse, int mb) {

	}

	public void onKeyTyped(int key, char character) {

	}

	public void onClosed() {

	}

	@Override
	public int height() {
		int height = button.height;
		if (open) {
			for (SettingButton<?> settingButton : settingButtons) {
				height += settingButton.height();
			}
		}
		return height;
	}

	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	public HudComponent getHudComponent() {
		return component;
	}
	
}
