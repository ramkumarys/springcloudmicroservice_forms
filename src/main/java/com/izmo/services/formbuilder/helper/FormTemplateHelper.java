package com.izmo.services.formbuilder.helper;

import java.util.Map;

import com.izmo.core.formbuilder.dto.FieldsDTO;
import com.izmo.core.formbuilder.dto.FormSettingsDTO;
import com.izmo.core.formbuilder.dto.WebFieldsDTO;
import com.izmo.core.formbuilder.schema.FieldSchema;
import com.izmo.core.formbuilder.schema.TimeSchema;
import com.izmo.core.formbuilder.schema.css.ButtonCssSchema;
import com.izmo.core.formbuilder.schema.css.DatePickerCssSchema;
import com.izmo.core.formbuilder.schema.css.DefaultFieldCssSchema;
import com.izmo.core.formbuilder.schema.css.ImageChoiceCssSchema;
import com.izmo.core.formbuilder.schema.css.RadioCssSchema;
import com.izmo.core.formbuilder.util.MapUtil;
import com.izmo.core.module.property.dto.IZMOPropertyValue;
import com.izmo.core.util.Constants;

public class FormTemplateHelper {

	/**
	 * 
	 * @param field
	 * @param layout
	 *            0-Single Row 1-One Row 2-Two Column
	 * 
	 */
	public String getLabelClass(FieldsDTO field, int layout) {
		if (field != null) {
			switch (layout) {
			case 2: {
				String labelClass = "col-md-4 col-sm-4 col-lg-4";
				String fullWidth = getFullWidth(field);
				if (fullWidth != null && !fullWidth.isEmpty()) {
					labelClass = "col-md-2 col-sm-2 col-lg-2";
				} else {
					labelClass = "col-md-4 col-lg-4 col-sm-4";
				}
				return labelClass;
			}
			case 1: {
				String labelClass = "col-md-3 col-sm-3 col-lg-3";
				return labelClass;
			}
			}
		}
		return "";
	}

	/**
	 * 
	 * @param field
	 * @param layout
	 *            0-Single Row 1-One Row 2-Two Column
	 * 
	 */
	public String getFieldClass(FieldsDTO field, int layout) {
		if (field != null) {
			switch (layout) {
			case 2: {
				String fieldClass = "col-md-8 col-lg-8 col-sm-8 col-xs-12";
				String fieldPosition = getFieldPosition(field);
				String fullWidth = getFullWidth(field);
				if (fullWidth != null && !fullWidth.isEmpty()) {
					if (fieldPosition != null && !fieldPosition.isEmpty() && "control".equals(fieldPosition)) {
						// Right Side Pull
						fieldClass = "col-md-10 col-sm-10 col-lg-10 col-xs-12 pull-right";
					} else {
						// Default Full Width
						fieldClass = "col-md-12 col-xs-12 col-sm-12 col-lg-12";
					}
				} else if (fieldPosition != null && !fieldPosition.isEmpty()) {
					if ("control".equals(fieldPosition)) {
						// Right Side Pull
						fieldClass = "col-md-8 col-sm-8 col-lg-8 col-xs-12 pull-right";
					} else {
						// Full Width Inside
						fieldClass = "col-md-12 col-xs-12 col-sm-12 col-lg-12";
					}
				}
				return fieldClass;
			}
			case 1: {
				String fieldClass = "col-md-9 col-lg-9 col-sm-9 col-xs-12";
				String fieldPosition = getFieldPosition(field);
				String fullWidth = getFullWidth(field);
				if (fullWidth != null && !fullWidth.isEmpty()) {
					if (fieldPosition != null && !fieldPosition.isEmpty() && "control".equals(fieldPosition)) {
						// Right Side Pull
						fieldClass = "col-md-9 col-sm-9 col-lg-9 col-xs-12 pull-right";
					} else if (field.getDisplayName() != null && !field.getDisplayName().isEmpty()
							&& !field.getHideLabel()) {
						// If Label Shown
						fieldClass = "col-md-9 col-lg-9 col-sm-9 col-xs-12";
					} else {
						// Default Full Width
						fieldClass = "col-md-12 col-xs-12 col-sm-12 col-lg-12";
					}
				} else if (fieldPosition != null && !fieldPosition.isEmpty()) {
					if ("control".equals(fieldPosition)) {
						// Right Side Pull
						fieldClass = "col-md-9 col-sm-9 col-lg-9 col-xs-12 pull-right";
					} else {
						// Full Width Inside
						fieldClass = "col-md-12 col-xs-12 col-sm-12 col-lg-12";
					}
				}
				return fieldClass;
			}

			}
		}
		return "";
	}

	public String getMandatoryTextPostion(FormSettingsDTO formSettings) {
		if (formSettings == null || formSettings.getMandatoryTextPosition() == null
				|| formSettings.getMandatoryTextPosition().isEmpty()) {
			return "top-right";
		}
		return formSettings.getMandatoryTextPosition();
	}

	public boolean showAdvancedIcons(Map<String, String> globalSettings) {
		return MapUtil.isEqualsIgnoreCase(globalSettings, "GS_ENABLE_ADVANCED_ICON", Constants.TRUE_STRING_VALUE);
	}

	public String getFontColor(Map<String, String> globalSettings) {
		String fontColor = "font_color_selected";
		if (MapUtil.isEqualsIgnoreCase(globalSettings, "FORM_FONT_COLOR", Constants.TRUE_STRING_VALUE)) {
			fontColor = MapUtil.getStringValue(globalSettings, "FORM_FONT_COLOR_SELECTED", fontColor, true);
		}

		return fontColor;
	}

	public String getFormFontColor(FormSettingsDTO formSettings) {
		if (formSettings == null || formSettings.getLabelColor() == null || formSettings.getLabelColor().isEmpty()
				|| formSettings.getLabelColor().equals("#") || formSettings.getLabelColor().equals("theme")) {
			return "";
		}
		return formSettings.getLabelColor();
	}

	public String getMandatorySymbol(Map<String, String> globalSettings, boolean astricOrPipe) {
		String value = "";
		if (!MapUtil.isEqualsIgnoreCase(globalSettings, "SHOW_MANDATORY_SYMBOL", Constants.TRUE_STRING_VALUE)) {
			return value;
		}
		if (astricOrPipe && MapUtil.isEqualsIgnoreCase(globalSettings, "SHOW_MANDATORY_SYMBOL_TYPE", "ASTERISK")) {
			return "asterisk_symbol";
		} else if (!astricOrPipe && MapUtil.isEqualsIgnoreCase(globalSettings, "SHOW_MANDATORY_SYMBOL_TYPE", "PIPE")) {
			return "pipe_symbol";
		}
		return value;
	}

	public boolean checkMandatoryText(Map<String, String> globalSettings, Map<String, IZMOPropertyValue> propertyMap) {
		boolean show = false;
		if (!MapUtil.isEqualsIgnoreCase(globalSettings, "SHOW_MANDATORY_SYMBOL", Constants.TRUE_STRING_VALUE)) {
			return show;
		}
		String propertyValue = MapUtil.getStringValue(propertyMap, "FORMS#FIELD_CONDITION", Constants.EMPTYSTRING);
		if (propertyValue == null || propertyValue.isEmpty()) {
			return show;
		}
		return true;
	}

	public boolean showMandatoryText(Map<String, String> globalSettings, Map<String, IZMOPropertyValue> propertyMap,
			String mandatoryTextPostion, String postion) {
		boolean show = false;
		if (!MapUtil.isEqualsIgnoreCase(globalSettings, "SHOW_MANDATORY_SYMBOL", Constants.TRUE_STRING_VALUE)) {
			return show;
		}
		String propertyValue = MapUtil.getStringValue(propertyMap, "FORMS#FIELD_CONDITION", Constants.EMPTYSTRING);
		if (propertyValue == null || propertyValue.isEmpty()) {
			return show;
		}
		if (postion == null || postion.isEmpty()) {
			postion = "top";
		}
		if (mandatoryTextPostion == null || mandatoryTextPostion.isEmpty()) {
			mandatoryTextPostion = "top-right";
		}
		if (mandatoryTextPostion.toLowerCase().contains(postion.toLowerCase())) {
			return true;
		}
		return show;
	}

	public String getTimeFormat(WebFieldsDTO field) {
		FieldSchema schema = field.getConfigData();
		if (schema == null || !(schema instanceof TimeSchema)) {
			return "";
		} else {
			TimeSchema tSchema = (TimeSchema) schema;
			return tSchema.getTimeFormat() != null ? tSchema.getTimeFormat() : "";
		}
	}

	private String getFullWidth(FieldsDTO field) {
		String fullWidth = null;
		if (field.getCssSchema() != null) {
			if (field.getCssSchema() instanceof DefaultFieldCssSchema) {
				fullWidth = ((DefaultFieldCssSchema) field.getCssSchema()).getFullWidth();
			} else if (field.getCssSchema() instanceof ButtonCssSchema) {
				fullWidth = ((ButtonCssSchema) field.getCssSchema()).getFullWidth();
			} else if (field.getCssSchema() instanceof RadioCssSchema) {
				fullWidth = ((RadioCssSchema) field.getCssSchema()).getFullWidth();
			} else if (field.getCssSchema() instanceof DatePickerCssSchema) {
				fullWidth = ((DatePickerCssSchema) field.getCssSchema()).getFullWidth();
			} else if (field.getCssSchema() instanceof ImageChoiceCssSchema) {
				fullWidth = ((ImageChoiceCssSchema) field.getCssSchema()).getFullWidth();
			}
		}
		return fullWidth;
	}

	private String getFieldPosition(FieldsDTO field) {
		if (field.getCssSchema() instanceof RadioCssSchema) {
			RadioCssSchema schema = (RadioCssSchema) field.getCssSchema();
			return schema.getFieldPosition();
		} else if (field.getCssSchema() instanceof DatePickerCssSchema) {
			DatePickerCssSchema schema = (DatePickerCssSchema) field.getCssSchema();
			return schema.getFieldPosition();
		} else if (field.getCssSchema() instanceof ImageChoiceCssSchema) {
			ImageChoiceCssSchema schema = (ImageChoiceCssSchema) field.getCssSchema();
			return schema.getFieldPosition();
		}
		return "";
	}

	public String getPropertyValue(Map<String, IZMOPropertyValue> propertyMap, String key, String defaultValue) {
		return MapUtil.getStringValue(propertyMap, key, defaultValue, true);
	}
}
