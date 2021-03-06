package com.tek.rcoreui.components;

import java.util.List;

import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import com.tek.rcoreui.InterfaceComponent;
import com.tek.rcoreui.InterfaceState;
import com.tek.rcoreui.InventoryUtils;
import com.tek.rcoreui.WrappedProperty;

public class RotateComponent extends InterfaceComponent {

	private List<ItemStack> rotation;
	private WrappedProperty<Integer> index;
	
	public RotateComponent(int x, int y, int width, int height, List<ItemStack> rotation) {
		super(x, y, width, height);
		this.rotation = rotation;
		this.index = new WrappedProperty<Integer>(0);
	}
	
	@Override
	public void render(InterfaceState interfaceState, ItemStack[][] drawBuffer) {
		InventoryUtils.drawFilledRectangle(drawBuffer, rotation.get(index.getValue()), x, y, width, height);
	}
	
	@Override
	public void onClick(InterfaceState interfaceState, ClickType type, ItemStack item, int x, int y) {
		int newIndex = index.getValue() + 1;
		if(newIndex >= rotation.size()) newIndex = 0;
		index.setValue(newIndex);
	}
	
	public WrappedProperty<Integer> getIndex() {
		return index;
	}
	
	public ItemStack getCurrentItem() {
		return rotation.get(index.getValue());
	}

}
