import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '时间',
    align:"center",
    dataIndex: 'datatime'
   },
   {
    title: '风速',
    align:"center",
    dataIndex: 'fengsu'
   },
   {
    title: '风向',
    align:"center",
    dataIndex: 'fengxiang'
   },
   {
    title: '温度',
    align:"center",
    dataIndex: 'wendu'
   },
   {
    title: '湿度',
    align:"center",
    dataIndex: 'shidu'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '时间',
    field: 'datatime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '风速',
    field: 'fengsu',
    component: 'InputNumber',
  },
  {
    label: '风向',
    field: 'fengxiang',
    component: 'InputNumber',
  },
  {
    label: '温度',
    field: 'wendu',
    component: 'InputNumber',
  },
  {
    label: '湿度',
    field: 'shidu',
    component: 'InputNumber',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];



/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}