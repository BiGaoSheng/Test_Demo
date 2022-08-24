function udsAddOrUpdateEarlyWarrantTc(RootFrameService, hdsapiWarrantUpdateWarrantZYResource,hdsapiWarrantInsertWarrantZYResource,$rootScope) {
    var event = arguments[0];
    var scope= arguments[1];
    debugger;
    if(scope.root.returnCarDTO.warrantDetailDTO.address==null||
        scope.root.returnCarDTO.warrantDetailDTO.address==""
    ){
        RootFrameService.alert("请填写必填字段！");
        return;
    }
    if(scope.root.returnCarDTO.warrantDetailDTO.recipients==null||
        scope.root.returnCarDTO.warrantDetailDTO.recipients==""
    ){
        RootFrameService.alert("请填写必填字段！");
        return;
    }
    if(scope.root.returnCarDTO.warrantDetailDTO.telephone==null||
        scope.root.returnCarDTO.warrantDetailDTO.telephone==""){
        RootFrameService.alert("请填写必填字段！");
        return;
    }
    if(scope.root.returnCarDTO.warrantDetailDTO.materialLendDetailVOList==null){
        RootFrameService.alert("请填写必填字段！");
        return;
    }
    if(scope.root.returnCarDTO.warrantDetailDTO.warrantDocList==null||
        scope.root.returnCarDTO.warrantDetailDTO.warrantDocList==""){
        RootFrameService.alert("请填写必填字段！");
        return;
    }
    if(scope.root.returnCarDTO.warrantDetailDTO.solutionData==null||
        scope.root.returnCarDTO.warrantDetailDTO.solutionData==""){
        RootFrameService.alert("请填写必填字段！");
        return;
    }

    var warrantId = scope.root.returnCarDTO.warrantDetailDTO.warrantId;
    var batchId = scope.root.returnCarDTO.businessKey;
    var data = scope.root.returnCarDTO.warrantDetailDTO;
    $rootScope.$broadcast('btn:start-submit', event.data);
    if(warrantId == null){
        data.batchId = batchId;
        hdsapiWarrantInsertWarrantZYResource.save(data).$promise.then(function(d) {
            scope.root.returnCarDTO.warrantDetailDTO.warrantId = d.result;
            RootFrameService.alert('权证回寄信息新增成功！');
            $rootScope.$broadcast('btn:end-submit', event.data);
        }, function(d) {
            RootFrameService.alert('权证回寄信息新增失败！');
            $rootScope.$broadcast('btn:end-submit', event.data);
        });
    }else{
        hdsapiWarrantUpdateWarrantZYResource.update(data).$promise.then(function(d) {
            RootFrameService.alert('权证回寄信息更新成功！');
            $rootScope.$broadcast('btn:end-submit', event.data);
        }, function(d) {
            RootFrameService.alert('权证回寄信息更新失败！');
            $rootScope.$broadcast('btn:end-submit', event.data);
        });
    }
}