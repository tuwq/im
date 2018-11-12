import FetchUtil from './../../util/FetchUtil';

export function allApi() {
    return FetchUtil.get(global.apiServerUrl+'/all')
}