/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 8.0.38 : Database - filetracking
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`filetracking` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `filetracking`;

/*Table structure for table `file_content` */

DROP TABLE IF EXISTS `file_content`;

CREATE TABLE `file_content` (
  `fileContentId` bigint NOT NULL AUTO_INCREMENT,
  `fileContent` mediumtext,
  `fileBarcode` varchar(20) DEFAULT NULL,
  `fileSubType` varchar(3) DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fileContentId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `file_content` */

insert  into `file_content`(`fileContentId`,`fileContent`,`fileBarcode`,`fileSubType`,`fileName`) values 
(1,'Bid Number/gyel wares (Rs gem):\nrs. ma\n> GeM [on— GEM/2024/B/5641892\nGovernment Azadi ka Dated i\nf e Marketplace “™r*Mahotsav ated/fes : 23-11-2024\nBid Document/ [9s Eads\nBid Details/fdz favor\nBid End Date/Time/[3 ag aa Hr ariw/ aad 09-12-2024 17:00:00\nBid Opening Date/Time/fas ged &\nP 9 [Time] 09-12-2024 17:30:00\nad@/aaa\nBid Offer Validity (From End Date)/R5 Qn 30 (Days)\n. ays\nduar (dg Aa Hr adi@ A)\nMinistry/State Name/daraa/Isd & IH Ministry Of Education\nDepartment Name/QHRT & AIH Department Of School Education And Literacy\nOrganisation Name/@3od &l A Kendriya Vidyalaya Sangathan\nOffice Name/®diad & IA Regional Office Bhubaneswar\nManpower Outsourcing Services - Minimum wage -\nUnskilled; Not Required; Others , Manpower Outsourcing\nServices - Minimum wage - Semi-skilled; Not Required;\nOthers , Manpower Outsourcing Services - Minimum wage -\nItem Category/ig Healt Unskilled; High School; Admin , Manpower Outsourcing\nServices - Minimum wage - Skilled; Graduate; Admin ,\nSecurity Manpower Service (Version 2.0) -\nOffice/Commercial/Institutions/ Residential; Unarmed\nSecurity Guard\nContract Period/3id 3/afd 1 Year(s)\nMinimum Average Annual Turnover of the\nbidder (For 3 Years)/fAsX & gaa iad 70 Lakh (s)\naf e=i3iar (3 auf a)\nYears of Past Experience Required for\nsame/similar service/5=</q#e Aai3it & OT | 3 year (s)\nfara Rea gaa & af\nPast Experience of Similar Services\nrequired/sd TRE HF Ad HF NS aT Yes\nHPT ¥\nMSE Exemption for Years Of\nExperience/3iJ@ & auf & vATES Pe/ and Yes\nTurnover/TA3I} & faU TATHS &F Tc Ud §\nStartup Exemption for Years Of\nExperience/3id & auf & FEU ge/ and Yes\nTurnover/ TAR & AUT TIENT FF Fe WH §\n1/14\nBid Details/fas faazor\nExperience Criteria,Bidder Turnover, Certificate (Requested\n. . in ATC),Additional Doc 1 (Requested in ATC)\nDocument required from seller/fshdl @ AFA | +n case any bidder is seeking exemption from Experience /\nNT SEAS Turnover Criteria, the supporting documents to prove his\neligibility for exemption must be uploaded for evaluation by\nthe buyer\nDo you want to show documents uploaded\nby bidders to all bidders participated in Yes\nbid?/\nType of Bid/ds & ya Single Packet Bid\nTime allowed for Technical Clarifications\nduring technical evaluation/daif 3[cAided & | 2 pays\nRa alt TaRAoT vq HFA FHT\nEstimated Bid Value/3igaiad fas sea 10700000\nEvaluation Method/#eid gid Total value wise evaluation\nEMD Detail/3uas aaron\nePBG Detail/$sdieish faazor\nAdvisory Bank/tsarssil §& State Bank of India\nDuration of ePBG required (Months)/3ddisit &r 1\nufaa af FER).\n(a). EMD & Performance security should be in favour of Beneficiary, wherever it is applicable./$TaEr 3iR urea\nSTATA TRY, ST FE AIL BI &, rdf & gat Ff gel afew)\nBeneficiary/arandf :\nPRINCIPAL\nRegional Office Bhubaneswar, Department of School Education and Literacy, KENDRIYA VIDYALAYA SANGATHAN,\nMinistry of Education\n(Aditya Kumar Panda)\nMII Compliance/TH3ME$3TS 3egarert\n2/14\nMSE Purchase Preference/tatds @ile adiar\n1. If the bidder is a Micro or Small Enterprise as per latest definitions under MSME rules, the bidder shall be\nexempted from the requirement of \"Bidder Turnover\" criteria and \"Experience Criteria\" subject to meeting of\nquality and technical specifications. If the bidder is OEM of the offered products, it would be exempted from the\n\"OEM Average Turnover\" criteria also subject to meeting of quality and technical specifications. In case any\nbidder is seeking exemption from Turnover / Experience Criteria, the supporting documents to prove his eligibility\nfor exemption must be uploaded for evaluation by the buyer.\n2. If the bidder is a Startup, the bidder shall be exempted from the requirement of \"Bidder Turnover\" criteria and\n\"Experience Criteria\" subject to their meeting of quality and technical specifications. If the bidder is OEM of the\noffered products, it would be exempted from the \"OEM Average Turnover\" criteria also subject to meeting of\nquality and technical specifications. In case any bidder is seeking exemption from Turnover / Experience Criteria,\nthe supporting documents to prove his eligibility for exemption must be uploaded for evaluation by the buyer.\n3. The minimum average annual financial turnover of the bidder during the last three years, ending on 31st\nMarch of the previous financial year, should be as indicated above in the bid document. Documentary evidence in\nthe form of certified Audited Balance Sheets of relevant periods or a certificate from the Chartered Accountant /\nCost Accountant indicating the turnover details for the relevant period shall be uploaded with the bid. In case the\ndate of constitution / incorporation of the bidder is less than 3-year-old, the average turnover in respect of the\ncompleted financial years after the date of constitution shall be taken into account for this criteria.\n4. Years of Past Experience required: The bidder must have experience for number of years as indicated above in\nbid document (ending month of March prior to the bid opening) of providing similar type of services to any\nCentral / State Govt Organization / PSU. Copies of relevant contracts / orders to be uploaded along with bid in\nsupport of having provided services during each of the Financial year.\n5. Purchase preference to Micro and Small Enterprises (MSEs): Purchase preference will be given to MSEs as\ndefined in Public Procurement Policy for Micro and Small Enterprises (MSEs) Order, 2012 dated 23.03.2012 issued\nby Ministry of Micro, Small and Medium Enterprises and its subsequent Orders/Notifications issued by concerned\nMinistry. If the bidder wants to avail the Purchase preference for services, the bidder must be the Service\nprovider of the offered Service. Relevant documentary evidence in this regard shall be uploaded along with the\nbid in respect of the offered service. If L-1 is not an MSE and MSE Service Provider (s) has/have quoted price\nwithin L-14+ 15% of margin of purchase preference /price band as defined in the relevant policy, then 100% order\nquantity will be awarded to such MSE bidder subject to acceptance of L1 bid price. The buyers are advised to\nrefer to the OM_No.1 4 2021 PPD_dated 18.05.2023 for compliance of Concurrent application of Public\nProcurement Policy for Micro and Small Enterprises Order, 2012 and Public Procurement (Preference to Make in\nIndia) Order, 2017. Benefits of MSE will be allowed only if the credentials of the service provider are validated on-\nline in GeM profile as well as validated and approved by the Buyer after evaluation of submitted documents.\n6. Estimated Bid Value indicated above is being declared solely for the purpose of guidance on EMD amount and\nfor determining the Eligibility Criteria related to Turn Over, Past Performance and Project / Past Experience etc.\nThis has no relevance or bearing on the price to be quoted by the bidders and is also not going to have any\nimpact on bid participation. Also this is not going to be used as a criteria in determining reasonableness of\nquoted prices which would be determined by the buyer based on its own assessment of reasonableness and\nbased on competitive prices received in Bid / RA process.\n7. Past Experience of Similar Services: The bidder must have successfully executed/completed similar Services\nover the last three years i.e. the current financial year and the last three financial years(ending month of March\nprior to the bid opening): -\n1. Three similar completed services costing not less than the amount equal to 40% (forty percent) of the\nestimated cost; or\n2. Two similar completed services costing not less than the amount equal to 50% (fifty percent) of the estimated\ncost; or\n3. One similar completed service costing not less than the amount equal to 80% (eighty percent) of the estimated\ncost.\nAdditional Qualification/Data Required/31fait® deadr /3maa® Ser\n\n3/14\nThe Bidder should have executed at least X No. projects with contract value not less than (Rs) yy for\neach contract of providing manpower services to Central/ State Government Departments/ Public\nSector Undertakings/ Autonomous Bodies in last N financial years:THE BIDDER SHOULD HAVE EXECUTED\nAT LEAST FIVE SIMILAR PROJECT.\nThe Bidder should have executed at least X No. projects with supply of xx..no. of manpower in each\ncontract of providing manpower services to Central/ State Government Departments/ Public Sector\nUndertakings/ Autonomous Bodies in last N financial years:THE BIDDER SHOULD HAVE EXECUTED AT\nLEAST FIVE SIMILAR PROJECT.\nGeographic Presence: Office registration certificate:ODISHA\nScope of work & Job description:1732359013.pdf\nBuyer to upload Gazette notification for the breakup of ESI/EPF/ELDI etc if required:1732359049.pdf\nBuyer to upload undertaking that Minimum Wages indicated by him during Bid Creation are as per\napplicable Minimum Wages Act:1732359073.pdf\nManpower Outsourcing Services - Minimum Wage - Unskilled; Not Required; Others (\n12)\nTechnical Specifications/da=idh RAfRAPAT\nTeoma pores\nero movers |\nAdditional Specification Documents/3ifaR® RARIT eras\n\n4/14\nConsignees/Reporting Officer/@RRd/Ruiféar 31rd\nConsignee\nS.No./&. || Reporting/Officer/ Number of Additional\n« TR, Rafe Address/adr Resources to || Requirement/3ifial®\n: e hire Tar\nforty ao\ne Minimum daily\nwage (INR)\nexclusive of GST :\n655\ne Bonus (INR per\nday): 0\neo EDLI (INR per day)\n:0\ne EPF Admin Charge\n(INR per day) : 0\ne Optional\nAllowances 1 (INR\nper day): 0\ne Optional\nAllowances 2 (INR\nper day) : 0\ne Optional\nAllowances 3 (INR\n751022,PM SHRI Kendriya . per day) <Q mber\n1 ADITYA KUMAR Vidyalaya No. |, BHOI NAGAR, 12 of Overtime Hours\nPANDA UNIT - IX BHUBANESWAR-\n751022 per Resource per\nMonth : 0\neo Remuneration per\nresource per hour\nfor Overtime Hours\n(Including all\napplicable\nallowance etc &\nexcluding GST) : 0\neo ESI (INR per day) :\n21.28\ne Provident Fund\n(INR per day) :\n85.15\ne Number of working\ndays in a month :\n26\ne Tenure/ Duration of\nEmployment (in\nmonths) : 12\nManpower Outsourcing Services - Minimum Wage - Semi-skilled; Not Required; Others\n(3)\nTechnical Specifications/da=lidh fafafEar\n5/14\nAdditional Specification Documents/3ifaR® RANI gras\nConsignees/Reporting Officer/qXRc/Raiféar fam\nConsignee\nS.No./&. || Reporting/Officer/ Number of Additional\nfer\n6/14\nConsignee\nS.No./&. || Reporting/Officer/ Number of Additional\no QR Raf Address/adr Resources to Requirement/31faR=®\n- e hire TAR\nforty a\neo Minimum daily\nwage (INR)\nexclusive of GST :\n502\ne Bonus (INR per\nday): 0\neo EDLI (INR per day)\n:0\neo EPF Admin Charge\n(INR per day): 0\ne Optional\nAllowances 1 (INR\nper day) : 0\ne Optional\nAllowances 2 (INR\nper day): 0\ne Optional\nAllowances 3 (INR\n751022,PM SHRI Kendriya . per day) ber\n1 ADITYA KUMAR Vidyalaya No. | , BHOI NAGAR, 3 of Overtime Hours\nPANDA UNIT - IX BHUBANESWAR-\n751022 per Resource per\nMonth : 0\ne Remuneration per\nresource per hour\nfor Overtime Hours\n(Including all\napplicable\nallowance etc &\nexcluding GST) : 0\ne ESI (INR per day) :\n16.31\ne Provident Fund\n(INR per day) :\n65.26\neo Number of working\ndays in a month :\n26\ne Tenure/ Duration of\nEmployment (in\nmonths) : 12\nManpower Outsourcing Services - Minimum Wage - Unskilled; High School; Admin ( 6)\nTechnical Specifications/daidh fafAEar\n7/14\nList of Profiles Multi-tasking Staff\n\nSpecialization Not Required\n\nPost Graduation Not Required\n\nSpecialization for PG Not Applicable\n\nAddon(s)/us3iia\nAdditional Specification Documents/3ifaR® RAR gras\nConsignees/Reporting Officer/qXRd/Raiféar ifr\n\nConsignee\nS.No./&. || Reporting/Officer/ Number of Additional\no Ry. Address/adr Resources to || Requirement/3iiaR®\n: be hired FTAA DA\nfd\n8/14\nConsignee\nS.No./&. || Reporting/Officer/ Number of Additional\nR/T Address/adr Resources to Requirement/31faR=®\n: e hire Tar\nfev ao\neo Minimum daily\nwage (INR)\nexclusive of GST :\n783\neo Bonus (INR per\nday): 0\neo EDLI (INR per day)\n:0\neo EPF Admin Charge\n(INR per day): 0\ne Optional\nAllowances 1 (INR\nper day) : 0\ne Optional\nAllowances 2 (INR\nper day): 0\ne Optional\nAllowances 3 (INR\n751022,PM SHRI Kendriya . per day) ber\n1 ADITYA KUMAR Vidyalaya No. | , BHOI NAGAR, of Overtime Hours\nPANDA UNIT - IX BHUBANESWAR-\n751022 per Resource per\nMonth : 0\ne Remuneration per\nresource per hour\nfor Overtime Hours\n(Including all\napplicable\nallowance etc &\nexcluding GST) : 0\ne ESI (INR per day) :\n25.44\ne Provident Fund\n(INR per day) :\n101.79\neo Number of working\ndays in a month :\n26\neo Tenure/ Duration of\nEmployment (in\nmonths) : 12\nManpower Outsourcing Services - Minimum Wage - Skilled; Graduate; Admin ( 2)\nTechnical Specifications/daidh fafAEar\n9/14\nList of Profiles Data Entry Operator\n\nPost Graduation Not Required\n\nSpecialization for PG Not Applicable\n\nAddon(s)/us3iia\n\nAdditional Details/31faRw® favor\nAdditional Specification Documents 3ifafR® ARIF gras\nConsignees/Reporting Officer/@Xc/Ruiféar fwd\nConsignee N\nS.No./®. || Reporting/Officer/ Number of Additional\n. i -. Address/adr Resources to || Requirement/3ifaR®\n9. be hired STaRIBAT\n3TH\n10/14\nConsignee\nS.No./&. || Reporting/Officer/ Number of Additional\nR/T Address/adr Resources to Requirement/31faR=®\n: e hire Tar\nfev ao\neo Minimum daily\nwage (INR)\nexclusive of GST :\n868\neo Bonus (INR per\nday): 0\neo EDLI (INR per day)\n:0\neo EPF Admin Charge\n(INR per day): 0\ne Optional\nAllowances 1 (INR\nper day) : 0\ne Optional\nAllowances 2 (INR\nper day): 0\ne Optional\nAllowances 3 (INR\n751022,PM SHRI Kendriya . per day) ber\n1 ADITYA KUMAR Vidyalaya No. | , BHOI NAGAR, 2 of Overtime Hours\nPANDA UNIT - IX BHUBANESWAR-\n751022 per Resource per\nMonth : 0\ne Remuneration per\nresource per hour\nfor Overtime Hours\n(Including all\napplicable\nallowance etc &\nexcluding GST) : 0\ne ESI (INR per day) :\n28.21\ne Provident Fund\n(INR per day) :\n112.84\neo Number of working\ndays in a month :\n26\neo Tenure/ Duration of\nEmployment (in\nmonths) : 12\nSecurity Manpower Service (Version 2.0) - Office/Commercial/Institutions/ Residential;\nUnarmed Security Guard ( 8)\nTechnical Specifications/daih fafAEar\n11/14\nCategory of Skills Semi skilled\n\nQualification High School\n\nAdditional Requirements for the Security Personnel\n\nAddon(s)/us3iia\n\nAdditional Details/31faRw® favor\nAdditional Specification Documents/3ifaR® RRR grads\nConsignees/Reporting Officer/aXc/Ruiféar ifasd\nConsignee\nS.No./®. || Reporting/Officer/ Number of Additional\n. RE Raf Address/adr resources to Requirement/3ifaRk®\n4. be hired TATE\n31m\n12/14\nConsignee\nS.No./&. || Reporting/Officer/ Number of Additional\nR/T Address/adr resources to Requirement/31faR=®\n: be hired TGR\n3rd\neo Number of working\ndays in a month :\n30\ne Tenure/ Duration of\nEmployment (in\nmonths) : 12\ne Basic Pay\n(Minimum daily\nwage) : 868\ne Provident Fund\n(INR per day) :\n751022,PM SHRI Kendriya 112.84\n1 ADITYA KUMAR Vidyalaya No. | , BHOI NAGAR, eo EDLI (INR per day)\nPANDA UNIT - IX BHUBANESWAR- : 0\n751022 e ESI (INR per day) :\n28.21\neo EPF Admin charge\n(INR per day): 0\neo Bonus (INR per\nday): 0\ne Optional Allowance\n1 (in Rupees) : 0\ne Optional Allowance\n2 (in Rupees) : 0\ne Optional Allowance\n3 (in Rupees) : 0\nBuyer Added Bid Specific Terms and Conditions/sa gu sid a5 Rs & fw of\n1. Generic\nOPTION CLAUSE: The buyer can increase or decrease the contract quantity or contract duration up to 25\npercent at the time of issue of the contract. However, once the contract is issued, contract quantity or\ncontract duration can only be increased up to 25 percent. Bidders are bound to accept the revised\nquantity or duration\n2. Buyer Added Bid Specific ATC\nBuyer Added text based ATC clauses\nPERFORMANCE SECURITY OF RS 3,00,000/ SHOULD BE DEPOSITED WITHIN 10 DAYS OF AWARD OF CONTR\nACT.\n3. Buyer Added Bid Specific ATC\nBuyer uploaded ATC document Click here to view the file.\nDisclaimer /s=hawor\n13/14\nThe additional terms and conditions have been incorporated by the Buyer after approval of the Competent\nAuthority in Buyer Organization, whereby Buyer organization is solely responsible for the impact of these clauses\non the bidding process, its outcome, and consequences thereof including any eccentricity / restriction arising in\nthe bidding process due to these ATCs and due to modification of technical specifications and / or terms and\nconditions governing the bid. If any clause(s) is / are incorporated by the Buyer regarding following, the bid and\nresultant contracts shall be treated as null and void and such bids may be cancelled by GeM at any stage of\nbidding process without any notice:-\n1. Definition of Class | and Class Il suppliers in the bid not in line with the extant Order / Office Memorandum\nissued by DPIIT in this regard.\n2. Seeking EMD submission from bidder(s), including via Additional Terms & Conditions, in contravention to\nexemption provided to such sellers under GeM GTC.\n3. Publishing Custom / BOQ bids for items for which regular GeM categories are available without any\nCategory item bunched with it.\n4. Creating BoQ bid for single item.\n5. Mentioning specific Brand or Make or Model or Manufacturer or Dealer name.\n6. Mandating submission of documents in physical form as a pre-requisite to qualify bidders.\n7. Floating / creation of work contracts as Custom Bids in Services.\n8. Seeking sample with bid or approval of samples during bid evaluation process. (However, in bids for\nattached categories, trials are allowed as per approved procurement policy of the buyer nodal Ministries)\n9. Mandating foreign / international certifications even in case of existence of Indian Standards without\nspecifying equivalent Indian Certification / standards.\n\n10. Seeking experience from specific organization / department / institute only or from foreign / export\nexperience.\n\n11. Creating bid for items from irrelevant categories.\n\n12. Incorporating any clause against the MSME policy and Preference to Make in India Policy.\n\n13. Reference of conditions published on any external site or reference to external documents/clauses.\n\n14. Asking for any Tender fee / Bid Participation fee / Auction fee in case of Bids / Forward Auction, as the\ncase may be.\n\n15. Any ATC clause in contravention with GeM GTC Clause 4 (xiii)(h) will be invalid. In case of multiple L1\nbidders against a service bid, the buyer shall place the Contract by selection of a bidder amongst the L-1\nbidders through a Random Algorithm executed by GeM system.\n\nFurther, if any seller has any objection/grievance against these additional clauses or otherwise on any aspect of\nthis bid, they can raise their representation against the same by using the Representation window provided in\nthe bid details field in Seller dashboard after logging in as a seller within 4 days of bid publication on GeM. Buyer\nis duty bound to reply to all such representations and would not be allowed to open bids if he fails to reply to\nsuch representations.\n\nThis Bid is governed by the General Terms and Conditions/arar=a fara 3iR ord, conditons stipulated in Bid and\nService Level Agreement specific to this Service as provided in the Marketplace. However in case if any condition\nspecified in General Terms and Conditions/@rar=a faze 3k ord is contradicted by the conditions stipulated in\nService Level Agreement, then it will over ride the conditions in the General Terms and Conditions.\n\nIn terms of GeM GTC clause 26 regarding Restrictions on procurement from a bidder of a country which shares a land border with India, any bidder from a country which\nshares a land border with India will be eligible to bid in this tender only if the bidder is registered with the Competent Authority. While participating in bid, Bidder has to\nundertake compliance of this and any false declaration and non-compliance of this would be a ground for immediate termination of the contract and further legal action\nin accordance with the laws./ 31 PT TTHTT AAT & TS 26 & HH A MT & AY HH Har ars FT dqTel SUA &b fx F wig\nW giddy & TE F HIT F TT JH AT AST A areal ST a drs off I= 37 [fae # Os ga & fow Jf ary gon\nSig gg fas a aren Fad Wed & wE Ghigd aIfds # WT dd FHT [FT HT SH gure den gen HR dre of\nTold =O FFT ST a SHA HUT dF Pel UW Jay Pl deblel HAH HA HR Feed & HFA 3M HT Prefell priars\nPN ITUTT ET |\n\n---Thank You/4=garg---\n14/14\n','2D0728220633','CBE','2D0728220633_CBE_DEM2024.pdf'),
(2,'manipalhospitals or\nLIFESON &\nManipal Hospital Bhubaneswar\nPlot No.1 Besides Satyasai Enclave Khandagiri, Bhubaneswar 751 030\nP +91 674 666 6600 URN : MH014208541\nOUTPATIENT RECORD\nHospital No:  MH014208541 Visit No: 030000682498\nName: MR PRUTHIRAJ MOHANTY Age/Sex: 56 Yrs/Male\nDoctor Name: DR. MAHESH PRASAD AGRAWALA Specialty: CARDIOLOGY MBO\nDate: 28/10/2024 11:06AM\nBP Systolic: 110 mmHg BP Diastolic: 80 mmHg Pulse Rate: 62beats per minute\nSaturation(Oxygen): 99% Respiration: 18breaths per minute Temperature: 98.2°F\nHeight: 164cm Weight : 55kg BMI: 20.45\nPain Score: 01\nHistory of presenting illness:\nSOB SINCE 2 -3 DAYS\nPALPITATION SINCE 3 DAYS\nPast Medical/Surgical History:\nDCMP ON IRREGULAR TREATMENT\nClinical examination:\nBP 100/70 MMHG\nPR 98/MIN IRREGULARLY IRREGULAR\nCHEST /CVS/ CNS NAD\nDiagnosis:\nDCMP LV SYSTOLIC DYSFUNCTION\nAF /FVR\nMedications:\nTAB CIDMUS 50MG 1/2 TAB BD\nTAB DYTOR PLUS 5 MG 1/2 TAB OD LUNCH\nTAB CARCA 3.125 OD ABF\nTAB OXRA 10 MG OD LUNCH\nTAB APIGAT 2.5 MG OD 4 PM\nCAP VELOZ D 20 MG OD BBF\nSYR CREMAFFIN PLUS 10 ML HS\nFollow up Advice:\nR/A 1 MONTH\nDR. MAHESH PRASAD AGRAWALA\n\"MBBS, MD (General Medicine) , DM (Cardiology)FIIC\"\nReg. No.: OMC12719\n1 of 1\nManipal Hospitals (East) India Private Limited\n(formerly known as AMRI Hospitals Private Limited and AMRI Hospitals Limited)\nCIN: U85110WB1986PTC040525\nRegd. Off. P-4 & 5, C.I.T Scheme-LXXII Block-A, Gariahat Road, Kolkata 700 029, West Bengal, India\nP +91 33 6626 0000 E info @manipalhospitals.com www.manipalhospitals.com\n','2D0728220633','REF','2D0728220633_REF_DEM32487.pdf');

/*Table structure for table `file_details` */

DROP TABLE IF EXISTS `file_details`;

CREATE TABLE `file_details` (
  `fileDetailsId` bigint NOT NULL AUTO_INCREMENT,
  `fileName` varchar(255) DEFAULT NULL,
  `fileType` varchar(255) DEFAULT NULL,
  `fileBarcode` varchar(30) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `CreatedBy` varchar(255) DEFAULT NULL,
  `CreatedDate` varchar(255) DEFAULT NULL,
  `IsActive` int NOT NULL,
  `ModifiedBy` varchar(255) DEFAULT NULL,
  `ModifiedDate` varchar(255) DEFAULT NULL,
  `loginId` bigint DEFAULT NULL,
  PRIMARY KEY (`fileDetailsId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `file_details` */

insert  into `file_details`(`fileDetailsId`,`fileName`,`fileType`,`fileBarcode`,`description`,`date`,`CreatedBy`,`CreatedDate`,`IsActive`,`ModifiedBy`,`ModifiedDate`,`loginId`) values 
(1,'DEM2024','PDC','2D0728220633','Test','2024-12-26',NULL,'2024-12-26 14:03:40',1,NULL,NULL,NULL),
(2,'DEM234','PDC','D4151746','Test','2024-12-23',NULL,'2024-12-26 15:17:46',1,NULL,NULL,NULL);

/*Table structure for table `file_status` */

DROP TABLE IF EXISTS `file_status`;

CREATE TABLE `file_status` (
  `fileStatusId` bigint NOT NULL AUTO_INCREMENT,
  `fileDetailsId` bigint DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `fileStatus` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fileStatusId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `file_status` */

insert  into `file_status`(`fileStatusId`,`fileDetailsId`,`date`,`fileStatus`,`comment`,`createdBy`) values 
(1,1,'2024-12-26 15:26:28','IN',NULL,'sachin'),
(2,1,'2024-12-26 15:26:34','OUT',NULL,'sachin');

/*Table structure for table `file_sub_type` */

DROP TABLE IF EXISTS `file_sub_type`;

CREATE TABLE `file_sub_type` (
  `fileSubTypeId` bigint NOT NULL AUTO_INCREMENT,
  `fileSubTypeCode` varchar(10) DEFAULT NULL,
  `fileSubTypeDesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fileSubTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `file_sub_type` */

insert  into `file_sub_type`(`fileSubTypeId`,`fileSubTypeCode`,`fileSubTypeDesc`) values 
(1,'CBE','CBE'),
(2,'REF','REF');

/*Table structure for table `file_type` */

DROP TABLE IF EXISTS `file_type`;

CREATE TABLE `file_type` (
  `FileTypeId` bigint NOT NULL AUTO_INCREMENT,
  `FileCode` varchar(255) DEFAULT NULL,
  `FileType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FileTypeId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `file_type` */

insert  into `file_type`(`FileTypeId`,`FileCode`,`FileType`) values 
(1,'PDC','PDC');

/*Table structure for table `file_upload` */

DROP TABLE IF EXISTS `file_upload`;

CREATE TABLE `file_upload` (
  `fileuploadId` bigint NOT NULL AUTO_INCREMENT,
  `fileBarcode` varchar(20) DEFAULT NULL,
  `fileSubType` varchar(3) DEFAULT NULL,
  `fileCode` varchar(255) DEFAULT NULL,
  `fileContentId` bigint DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `createdBy` bigint DEFAULT NULL,
  `createdDate` varchar(255) DEFAULT NULL,
  `modifiedBy` bigint DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `isActive` int DEFAULT NULL,
  PRIMARY KEY (`fileuploadId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `file_upload` */

insert  into `file_upload`(`fileuploadId`,`fileBarcode`,`fileSubType`,`fileCode`,`fileContentId`,`fileName`,`createdBy`,`createdDate`,`modifiedBy`,`modifiedDate`,`isActive`) values 
(1,'2D0728220633','CBE',NULL,NULL,'2D0728220633_CBE_DEM2024.pdf',NULL,NULL,NULL,NULL,1),
(2,'2D0728220633','REF',NULL,NULL,'2D0728220633_REF_DEM32487.pdf',NULL,NULL,NULL,NULL,1);

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(1);

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `LoginId` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `PersonalEmail` varchar(255) DEFAULT NULL,
  `Dob` date DEFAULT NULL,
  `Pan` varchar(10) DEFAULT NULL,
  `DesignationId` bigint DEFAULT NULL,
  `empId` varchar(255) DEFAULT NULL,
  `isActive` int NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` varchar(255) DEFAULT NULL,
  `modifiedBy` varchar(255) DEFAULT NULL,
  `modifiedDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`LoginId`),
  UNIQUE KEY `userUnique` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

/*Data for the table `login` */

insert  into `login`(`LoginId`,`username`,`Password`,`FirstName`,`LastName`,`PersonalEmail`,`Dob`,`Pan`,`DesignationId`,`empId`,`isActive`,`createdBy`,`createdDate`,`modifiedBy`,`modifiedDate`) values 
(1,'sachin','$2y$12$QTTMcjGKiCVKNvNa242tVu8SPi0SytTAMpT3XRscxNXHHu1nY4Kui','Raghav','Madhur',NULL,'1993-09-05',NULL,1,'1',1,'subrat',NULL,NULL,'2022-12-16 17:25:18'),
(8,'gopi@vedts.com','$2a$10$rOyETcCDGoAjX2UYL6tnyu7Zqg90b886LQ1PftGmh4tzR1uKpNagi','Gopi','parhi','gopi@vedts.com','2022-12-13','TERSFREWWE',1,NULL,1,'sachin','2022-12-18 20:44:12','sachin','2022-12-18 20:45:17');

/*Table structure for table `login_role_security` */

DROP TABLE IF EXISTS `login_role_security`;

CREATE TABLE `login_role_security` (
  `LoginRoleSecurityId` bigint NOT NULL AUTO_INCREMENT,
  `LoginId` bigint DEFAULT NULL,
  `RoleId` bigint DEFAULT NULL,
  PRIMARY KEY (`LoginRoleSecurityId`),
  KEY `FYLOGIN` (`LoginId`),
  KEY `FYROLEID` (`RoleId`),
  CONSTRAINT `FKLOGIN` FOREIGN KEY (`LoginId`) REFERENCES `login` (`LoginId`),
  CONSTRAINT `FKROLE` FOREIGN KEY (`RoleId`) REFERENCES `role_security` (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `login_role_security` */

insert  into `login_role_security`(`LoginRoleSecurityId`,`LoginId`,`RoleId`) values 
(1,1,1),
(10,8,1);

/*Table structure for table `login_seq` */

DROP TABLE IF EXISTS `login_seq`;

CREATE TABLE `login_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login_seq` */

insert  into `login_seq`(`next_val`) values 
(1);

/*Table structure for table `role_security` */

DROP TABLE IF EXISTS `role_security`;

CREATE TABLE `role_security` (
  `RoleId` bigint NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

/*Data for the table `role_security` */

insert  into `role_security`(`RoleId`,`RoleName`) values 
(1,'ROLE_ADMIN'),
(2,'ROLE_EMP'),
(3,'ROLE_MANG'),
(4,'ROLE_HR');

/*Table structure for table `role_security_seq` */

DROP TABLE IF EXISTS `role_security_seq`;

CREATE TABLE `role_security_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `role_security_seq` */

insert  into `role_security_seq`(`next_val`) values 
(1);

/*Table structure for table `speech_content` */

DROP TABLE IF EXISTS `speech_content`;

CREATE TABLE `speech_content` (
  `speechContentId` bigint NOT NULL AUTO_INCREMENT,
  `content` mediumtext,
  `CreatedBy` bigint DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedBy` bigint DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `IsActive` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`speechContentId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `speech_content` */

insert  into `speech_content`(`speechContentId`,`content`,`CreatedBy`,`CreatedDate`,`ModifiedBy`,`ModifiedDate`,`IsActive`) values 
(1,'hi hello how are you I am fine what\'s about you',1,'2023-02-26 11:04:24',NULL,NULL,1),
(2,'how are you you are good',1,'2023-02-26 11:06:31',NULL,NULL,1),
(3,'hello hello hello hello',1,'2023-04-13 21:22:26',NULL,NULL,1),
(4,'hello hello',1,'2023-04-13 22:34:19',NULL,NULL,1),
(5,'hello hi I miss Kumar Mohanty I am from Orissa MC marking senior software engineer in NTT Data I have a good knowledge and Java Spring springboard Hibernate micro services I have work experience stuck engineer',1,'2023-12-09 07:04:07',NULL,NULL,1),
(6,'hi this is Hitesh Kumar wanti',1,'2024-06-21 14:14:13',NULL,NULL,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
