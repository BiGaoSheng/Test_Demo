function udsAddOrUpdateEarlyPostmailQzjq(RootFrameService, hdsapiPostmailUpdatePostmailZYResource,hdsapiPostmailInsertPostmailZYResource,$rootScope) {
    var event = arguments[0];
    var scope= arguments[1];

    if(scope.root.dealApplyCombDTO.postMailDetailDTO.mailNum==null||
        scope.root.dealApplyCombDTO.postMailDetailDTO.mailNum==""){
        RootFrameService.alert("请填写必填字段！");
        return;
    }
    if(scope.root.dealApplyCombDTO.postMailDetailDTO.recipients==null||
        scope.root.dealApplyCombDTO.postMailDetailDTO.recipients==""){
        RootFrameService.alert("请填写必填字段！");
        return;
    }
    if(scope.root.dealApplyCombDTO.postMailDetailDTO.recipientsAddress==null||
        scope.root.dealApplyCombDTO.postMailDetailDTO.recipientsAddress==""){
        RootFrameService.alert("请填写必填字段！");
        return;
    }
    if(scope.root.dealApplyCombDTO.postMailDetailDTO.mailDocList==null||
        scope.root.dealApplyCombDTO.postMailDetailDTO.mailDocList==""){
        RootFrameService.alert("请填写必填字段！");
        return;
    }
    var postId = scope.root.dealApplyCombDTO.postMailDetailDTO.postId;
    var batchId = scope.root.dealApplyCombDTO.returnCarBaseDTO.batchId;
    var data = scope.root.dealApplyCombDTO.postMailDetailDTO;
    $rootScope.$broadcast('btn:start-submit', event.data);
    debugger;
    if(postId == null){
        data.batchId = batchId;
        hdsapiPostmailInsertPostmailZYResource.save(data).$promise.then(function(d) {
            scope.root.earlySettleManageApplyDTO.postMailDetailDTO.postId = d.result;
            RootFrameService.alert('邮寄信息新增成功！');
            $rootScope.$broadcast('btn:end-submit', event.data);
        }, function(d) {
            RootFrameService.alert('邮寄信息新增失败！');
            $rootScope.$broadcast('btn:end-submit', event.data);
        });
    }else{
        hdsapiPostmailUpdatePostmailZYResource.update(data).$promise.then(function(d) {
            RootFrameService.alert('邮寄信息更新成功！');
            $rootScope.$broadcast('btn:end-submit', event.data);
        }, function(d) {
            RootFrameService.alert('邮寄信息更新失败！');
            $rootScope.$broadcast('btn:end-submit', event.data);
        });
    }
}