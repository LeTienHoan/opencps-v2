<#if (Request)??>
<#include "init.ftl">
</#if>
<div id="detailDossier">
	<div class="box">

		<input type="hidden" name="dossierStatus" id="dossierStatus">
		
		<input type="hidden" name="dossierTemplateNo" id="dossierTemplateNo">
		<div class="row-header align-middle">
			<div class="background-triangle-big">Tên thủ tục</div> 
			<span class="text-bold" data-bind="text:serviceName"></span>
			<div class="pull-right group-icons">
				<a href="javascript:;" onclick="fnBack();" >
					<i class="fa fa-reply" aria-hidden="true"></i>
					Quay lại
				</a>
			</div>
		</div>

		<div class="dossier-general-info P15 MB30">
			<p class="text-bold">Thông tin chung hồ sơ</p>
			<div class="col-sm-4">
				<div class="row MB5">
					<span class="text-bold">Mã tiếp nhận</span>: <span data-bind="text:govAgencyName"></span>
				</div>
				<div class="row" id="">
					<a href="javascript:;" class="text-blue text-underline">Thông tin chủ hồ sơ</a>
				</div>
			</div>
			<div class="col-sm-4 text-center">
				<div class="row MB5" id="">
					<span class="text-bold">Thời gian gửi</span>: <span data-bind="text:submitDate"></span>
				</div>
				<div class="row" id="">
					<span class="text-bold">Mã số hồ sơ</span>: <span data-bind="text : dossierId"></span>
				</div>
			</div>
			
			<div class="col-sm-4 text-center">
				<div class="row MB5" id="">
					<span class="text-bold">Tình trạng</span>: <span data-bind="text:dossierStatusText"></span>
				</div>
				
			</div>
			
		</div>

		<div class="guide-section PB0">
			<div class="head-part" data-toggle="collapse" data-target="#collapseDossierG">
				<div class="background-triangle-small">
					<i class="fa fa-star"></i>

				</div> 
				<span class="text-uppercase hover-pointer">Hướng dẫn</span> 
				<i class="fa fa-angle-down pull-right hover-pointer MR15" aria-hidden="true" style="font-size: 150%;"></i>
			</div>

			<div class="content-part collapse PB15" id="collapseDossierG">
				<span data-bind="html:stepInstruction"></span>
				<#-- <p class="MB0 text-light-blue PB15"><a href="javascript:;" id="guide-toggle">Xem thêm >></a></p> -->
			</div>

		</div>

		<div class="dossier-parts" id="paymentDossier">
			<div class="head-part align-middle MB5" data-toggle="collapse" data-target="#collapseDossierPayment">
				<div class="background-triangle-small">III</div> 
				<div class="col-sm-12 PL0">

					<span class="text-uppercase hover-pointer">Thanh toán</span>
					<i class="fa fa-angle-down pull-right hover-pointer" aria-hidden="true" style="font-size: 150%;"></i>
				</div>

			</div>
			<div class="content-part collapse in" id="collapseDossierPayment">
				<div class="row-parts-head MT5">
					<div class="row">
						<div class="col-sm-12" id="paymentDossierContent" data-bind="value: paymentDossier">

							<div class="row MB5">
								<div class="col-sm-2">								
									<span class="text-bold">Tên phí thanh toán</span>	
								</div>
								<div class="col-sm-10" data-bind="text: paymentFee"></div> 
							</div>

							<div class="row MB5">
								<div class="col-sm-2">								
									<span class="text-bold">Gía trị thanh toán</span>	
								</div>
								<div class="col-sm-10 red" data-bind="text:paymentAmount"></div>
							</div>

							<div class="row MB5">
								<div class="col-sm-2">								
									<span class="text-bold">Chuyển khoản đến</span>	
								</div>
								<div class="col-sm-10" data-bind="text:paymentGovAgencyName "></div>
							</div>

							<div class="row MB5">
								<div class="col-sm-2">								
									<span class="text-bold">Thông tin tài khoản nhận</span>
								</div>
								<div class="col-sm-10" data-bind="text:paymentBankInfo"></div>
							</div>


							<div class="row MB5">
								<div class="col-sm-2">								
									<span class="text-bold">Trạng thái</span>	
								</div>
								<div class="col-sm-10" data-bind="text:paymentStatus"></div>
							</div>

							<div class="row MB10">
								<div class="col-sm-2">								
									<span class="text-bold">Ngày thanh toán</span>	
								</div>
								<div class="col-sm-10" data-bind="text:paymentApproveDatetime"></div>
							</div>

							<div id="unpaid">
								<div class="row MB10">
									<div class="col-sm-12">
										<button class="btn btn-sm btn-border-color MR10 text-light-blue" onclick="">Thanh toán trực tuyến</button> 
										<button class="btn btn-sm btn-border-color MR10 text-light-blue" onclick="">Thông báo đã nộp chuyển khoản</button>
										<button class="btn btn-sm btn-border-color text-light-blue" onclick="">Xem phiếu thanh toán</button>
									</div>
								</div>

								<div class="row MB20 MT20" data-bind="value: isPay">
									<div class="col-sm-12 text-center">
										<div class="row">
											<div class="col-sm-4">

											</div>
											<div class="col-sm-4 text-center MB10">
												<i class="fa fa-file-image-o text-center text-light-gray MB10" aria-hidden="true" style="font-size:100px;">
													
												</i> <br>
												<span class="text-center" style="font-size: 10px;">Chứng từ thanh toán cho chuyển khoản là giấy yêu cầu nộp tiền vào ngân hàng hoặc hóa đơn chứng nhận giao dịch chuyển khoản được in ra</span>
											</div>
											<div class="col-sm-4">

											</div>
										</div>
										<input type="file" id="file" name="file" class="hidden" >
										<label class="btn btn-sm MB0 ML10 hover-pointer" for="file" title="Tải file lên" >
											<span class="text-normal">Chọn ảnh từ máy</span>
										</label>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-11">
										<div class="form-group"> 
											<label class="control-label">Ghi chú kèm theo</label> 
											<textarea class="form-control" rows="2" id="confirmNote" name="confirmNote" data-bind="text:confirmNote">

											</textarea> 
										</div>
									</div> 
									<div class="col-sm-1 MT30">
										<button class="btn">Gửi</button>
									</div>
								</div>
							</div>

							<#-- <div id="alreadyPaid" data-bind="value: isPay">
								<div class="row MB5">
									<div class="col-sm-2">								
										<span class="text-bold">Ghi chú kèm theo</span>	
									</div>
									<div class="col-sm-10" data-bind="text: paymentConfirmNote"></div>
								</div>

								<div class="row MB5">
									<div class="col-sm-2">								
										<span class="text-bold">Chứng từ kèm theo</span>	
									</div>
									<div class="col-sm-10" data-bind="text: paymentBankInfo"></div>
								</div>
							</div>
 -->
						</div>
					</div>
				</div>
			</div>
		</div> 

	</div>
	<div class="button-row MT20">
		<button class="btn btn-active" id="btn-submit-dossier" type="button" onclick="fnBack();"><i class="fa fa-reply" aria-hidden="true"></i> Quay lại</button>
	</div>
</div>

<script type="text/javascript">

	var fnLoadPayment = function(dossierId){

		console.log(dossierId);
		var resultModel = null;
		if(dossierId){
			$.ajax({
				url : "${api.server}/dossiers/"+dossierId+"/payments",
				dataType : "json",
				type : "GET",
				headers : {"groupId": ${groupId}},
				async : false,
				data : {
				},
				success : function(result){
					if(result.data){
						resultModel = result.data[0];
					}
				},
				error :  function(result){
					$("#paymentDossier").hide();
				}

			});
		}

		return resultModel;
	}
	var fnBack = function(){
		window.history.back();
	};

	var printDetailDossier = function(dossierId){
		if(dossierId){
			$.ajax({
				url : "${api.server}/dossiers/"+dossierId,
				dataType : "json",
				type : "GET",
				headers : {"groupId": ${groupId}},
				success : function(result){
					console.log("load detail dossier!");
					console.log(result.dossierId);
					dataSourceDossierTemplate.read({
						dossierTemplateNo : result.dossierTemplateNo
					});

					var payment = fnLoadPayment(result.dossierId);
					

					var viewModel = kendo.observable({

						dossierId : result.dossierId,
						serviceName : result.serviceName,
						govAgencyName : result.govAgencyName,
						dossierNo : result.dossierNo,
						dossierStatusText : result.dossierStatusText,
						stepInstruction : result.stepInstruction,
						dossierStatus : result.dossierStatus,
						paymentDossier : payment,
						paymentFee : function(e){
							console.log(this.get('paymentDossier'));
							if(this.get('paymentDossier').paymentFee){
								return this.get('paymentDossier').paymentFee;
							}
							return "";
						},
						paymentAmount : function(e){
							if(this.get('paymentDossier').paymentAmount){
								return this.get('paymentDossier').paymentAmount;
							}
							return "";
						},
						paymentGovAgencyName : function(e){
							if(this.get('paymentDossier').govAgencyName){
								return this.get('paymentDossier').govAgencyName;
							}
							return "";
						},
						paymentBankInfo : function(e){
							if(this.get('paymentDossier').bankInfo){
								return this.get('paymentDossier').bankInfo;
							}
							return "";
						},
						paymentStatus : function(e){
							if(this.get('paymentDossier').paymentStatus){
								return this.get('paymentDossier').paymentStatus;
							}
							return "";
						},
						paymentApproveDatetime : function(e){
							if(this.get('paymentDossier').approveDatetime){
								return this.get('paymentDossier').approveDatetime;
							}
							return "";
						},
						paymentConfirmNote : function(e){
							if(this.get('paymentDossier').confirmNote){
								return this.get('paymentDossier').confirmNote;
							}
							return "";
						},
						isPay : function(){
							if(this.get('paymentDossier').paymentStatus !== 2){
								$("#unpaid").show();
								$("#alreadyPaid").hide();
							}
						},
						submitting : function(){
							if(result.submitting){
								$("#btn-submit-dossier").hide();
							}
						}

						/*dossierTemplateNo : function(e){
							dataSourceDossierTemplate.read({
								dossierPart : 201 //result.dossierTemplateNo
							});	
						}*/

					});

					kendo.bind($("#detailDossier"), viewModel);
				},
				error : function(result){
					$("#paymentDossierContent").html("");
				}

			});
		}
	}

	printDetailDossier(${dossierId});

	
</script>