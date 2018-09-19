/**
 * input-utils.js
 */

var CheckBox_utils = {
		
	isChecked : function (event){
		return $(event).is(":checked");
	},
	allCheckBoxToggle : function (event, target){
		if(this.isChecked(event)){
			target.prop('checked', true);			
		}else{
			target.prop('checked', false);
		}
	}
	
}