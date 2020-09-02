import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormlyFieldConfig } from '@ngx-formly/core';
import { OpenehrSdkService } from '../openehr-sdk.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  diagnosis: {} = null;
  ehrId: string;

  constructor(private ehrService: OpenehrSdkService) {

  }

  ngOnInit() {
    this.ehrService.currentEhrId.subscribe(
      ehrId => this.ehrId = ehrId )
  }


  form = new FormGroup({});

  model = {
    language: 'DE',
    territory: 'DE',
    healthCareFacility: {
      name: 'MHH',
    },
    startTimeValue: new Date(),
    settingDefiningcode: 'SECONDARY_MEDICAL_CARE',
    categoryDefiningcode: 'EVENT',
    problemDiagnose: {
      subject: {
        name: 'self'
      },
      letztesDokumentationsdatumValue: new Date(),
      language: 'DE',
      atiopathogenese: {
        atiologieDerKrankheit: [{}],
      },
    },
  };
  fields: FormlyFieldConfig[] = [
    {
      key: 'language',
      type: 'input',
      hide: true,
      templateOptions: {
        required: true,
      }
    },
    {
      key: 'territory',
      type: 'input',
      hide: true,
      templateOptions: {
        required: true,
      }
    },
    {
      key: 'healthCareFacility',
      wrappers: ['panel'],
      templateOptions: {
        label: 'Einrichtung'
      },
      fieldGroup: [
        {
          key: 'name',
          type: 'input',
          templateOptions: {
            label: 'Einrichtung',
            placeholder: 'Bitte Einrichtung eingeben',
          }
        },
        {
          key: 'identifiers',
          type: 'input',
          hide: true,
        }
      ]
    },
    {
      key: 'startTimeValue',
      type: 'input',
      hide: true,
      templateOptions: {
        required: true,
        type: 'date',
      },
    },
    {
      key: 'berichtIdValue',
      type: 'input',
      hide: true,
      templateOptions: {
        label: 'Bericht ID',
        placeholder: 'Bitte Bericht ID angeben',
      },
    },
    {
      key: 'fallidentifikation',
      wrappers: ['panel'],
      templateOptions: {
        required: true,
        label: 'Fallidentifikation',
      },
      fieldGroup: [
        {
          key: 'fallKennungValue',
          type: 'input',
          templateOptions: {
            label: 'Fall-Kennung',
            placeholder: 'Bitte Fall-Kennung angeben',
            required: true,
          }
        },
      ]
    },
    {
      key: 'composer',
      wrappers: ['panel'],
      templateOptions: {
        required: true,
        label: 'Dokumentar',
      },
      fieldGroup: [
        {
          key: 'externalRef',
          type: 'input',
          hide: true,
          templateOptions: {
            required: false,
          }
        },
        {
          key: 'name',
          type: 'input',
          templateOptions: {
            label: 'Name',
            required: true,
          }
        },
        {
          key: 'identifiers',
          type: 'input',
          hide: true,
          templateOptions: {
            required: false,
          }
        },
      ]
    },
    {
      key: 'settingDefiningcode',
      type: 'input',
      hide: true,
      templateOptions: {
        required: true,
      }
    },
    {
      key: 'location',
      type: 'input',
      hide: true,
      templateOptions: {
        required: false,
      }
    },
    {
      key: 'categoryDefiningcode',
      type: 'input',
      hide: true,
      templateOptions: {
        required: true,
      }
    },
    {
      key: 'problemDiagnose',
      wrappers: ['panel'],
      templateOptions: {
        label: 'Problem/Diagnose',
      },
      fieldGroup: [
        {
          key: 'subject',
          wrappers: ['panel'],
          hide: true,
          templateOptions: {
            required: true,
          },
          fieldGroup: [
            {
              key: 'externalRef',
              type: 'input',
              hide: true,
              templateOptions: {
                required: false,
              }
            },
            {
              key: 'name',
              type: 'input',
              templateOptions: {
                label: 'Name',
                required: true,
              }
            },
            {
              key: 'identifiers',
              type: 'input',
              hide: true,
              templateOptions: {
                required: false,
              }
            },
          ]
        },
        {
          key: 'nameDesProblemsDerDiagnoseValue',
          type: 'input',
          templateOptions: {
            label: 'Name des Problems/ der Diagnose',
            placeholder: 'Bitte Name des Problems/ der Diagnose angeben',
            required: true,
          }
        },
        {
          key: 'freitextbeschreibungValue',
          type: 'input',
          templateOptions: {
            label: 'Freitextbeschreibung',
            placeholder: 'Bitte Freitextbeschreibung angeben',
          }
        },
        {
          key: 'lokalisationValue',
          type: 'input',
          templateOptions: {
            label: 'Lokalisation',
            placeholder: 'Bitte Lokalisation angeben',
          }
        },
        {
          key: 'anatomischeLokalisation',
          type: 'repeat',
          templateOptions: {
            addText: 'Weitere anatomische Lokalisationen hinzufügen',
          },
            fieldArray: {
              fieldGroup: [
                {
                  key: 'nameDerKorperstelleValue',
                  type: 'input',
                  templateOptions: {
                    label: 'Name der Körperstelle',
                    placeholder: 'Bitte Name der Körperstelle angeben',
                    required: true,
                  }
                },
                {
                  key: 'lateralitatDefiningcode',
                  type: 'radio',
                  templateOptions: {
                    label: 'Lateralität',
                    options: [
                      { value: 'LINKS', label: 'Links'  },
                      { value: 'RECHTS',label: 'Rechts'  },
                      ],
                    },
                },
            ],
          },
        },
        {
          key: 'datumDesAuftretensDerErstdiagnoseValue',
          type: 'input',
          templateOptions: {
            label: 'Datum des Auftretens/der Erstdiagnose',
            placeholder: 'Bitte Datum des Auftretens/der Erstdiagnose angeben',
            type: 'date',
          },
        },
        {
          key: 'feststellungsdatumValue',
          type: 'input',
          templateOptions: {
            label: 'Feststellungsdatum',
            placeholder: 'Bitte Feststellungsdatum angeben',
            type: 'date',
          },
        },
        {
          key: 'schweregrad',
          wrappers: ['panel'],
          templateOptions: {
            label: 'Schweregrad'
          },
          fieldGroup: [
            {
              key: 'schweregradDefiningcode',
              type: 'radio',
              templateOptions: {
                options: [
                  { value: 'LEICHT', label: 'Leicht'  },
                  { value: 'MASIG', label: 'Mäßig'  },
                  { value: 'SCHWER', label: 'Schwer'  },
                  ],
                },
              },
          ]
        },
          {
            key: 'diagnosedetails',
            wrappers: ['panel'],
            templateOptions: {
              label: 'Diagnosedetails',
            },
              fieldGroup: [
                {
                  key: 'begrundungVonAusnahmenValue',
                  type: 'input',
                  templateOptions: {
                    label: 'Begründung von Ausnahmen',
                    placeholder: 'Bitte Begründung von Ausnahmen angeben',
                  }
                },
                {
                  key: 'diagnosetypValue',
                  type: 'select',
                  templateOptions: {
                    label: 'Diagnosetyp',
                    placeholder: 'Bitte Diagnosetyp angeben',
                    options: [
                      { value: 'AUFNAHMEDIAGNOSE', label: 'Aufnahmediagnose'  },
                      { value: 'OPERATIONSDIAGNOSE', label: 'Operationsdiagnose'  },
                      { value: 'ENTLASSDIAGNOSE', label: 'Entlassdiagnose'  },
                      { value: 'TODESURSACHE', label: 'Todesursache'  },
                      { value: 'VERSORGUNGSFALLHAUPTDIAGNOSE', label: 'Versorgungsfallhauptdiagnose'  },
                      { value: 'ABTEILUNGSFALLHAUPTDIAGNOSE', label: 'Abteilungsfallhauptdiagnose'  },
                      { value: 'SONSTIGE', label: 'Sonstige'  },
                      { value: 'VERSORGUNGSFALLNEBENDIAGNOSE', label: 'Versorgungsfallnebendiagnose'  },
                      { value: 'ABTEILUNGSFALLNEBENIAGNOSE', label: 'Abteilungsfallnebendiagnose'  },
                    ],
                  },
                },
                {
                  key: 'vorhandenBeiAufnahmeValue',
                  type: 'checkbox',
                  templateOptions: {
                    label: 'Vorhanden bei Aufnahme',
                  },
                },
                {
                  key: 'vorhandenBeiEntlassungValue',
                  type: 'checkbox',
                  templateOptions: {
                    label: 'Vorhanden bei Entlassung',
                  },
                },
              ]
            },
        {
          key: 'atiopathogenese',
          wrappers: ['panel'],
          templateOptions: {
            label: 'Ätiopathogenese',
          },
          fieldGroup: [
            {
            key: 'atiologieDerKrankheit',
            type: 'repeat',
            templateOptions: {
              addText: 'Weitere Äthiologien der Krankheit hinzufügen',
            },
            fieldArray: {
              fieldGroup: [
                {
                  key: 'value',
                  wrappers: ['panel'],
                  fieldGroup: [
                    {
                      key: 'definingcode',
                      type: 'select',
                      templateOptions: {
                        label: 'Ätiologie der Krankheit',
                        placeholder: 'Bitte Ätiologie der Krankheit angeben',
                        options: [
                          { value: 'ARBEITSRISIKOFAKTOREN', label: 'Arbeitsrisikofaktoren'  },
                          { value: 'BIOLOGISCH', label: 'Biologisch'  },
                          { value: 'CHEMISCHE_VERLETZUNG', label: 'Chemische Verletzung'  },
                          { value: 'ERNAHRUNGSRELEVANTE_FAKTOREN', label: 'Ernährungsrelevante Faktoren'  },
                          { value: 'GENETISCHE_HERKUNFT', label: 'Genetische Herkunft'  },
                          { value: 'IMMUNOLOGISCHE_HERKUNFT', label: 'Immunologische Herkunft'  },
                          { value: 'INFEKTION', label: 'Infektion'  },
                          { value: 'KORPERLICHE_VERLETZUNG', label: 'Körperliche Verletzung'  },
                          { value: 'LEBENSWANDEL_BEZOGENE_FAKTOREN', label: 'Lebenswandel-bezogene Faktoren'  },
                          { value: 'METABOLISCH_ENDOKRINER_HERKUNFT', label: 'Metabolisch-endokriner Herkunft'  },
                          { value: 'NEUROPSYCHIATRISCHE_HERKUNFT', label: 'Neuropsychiatrische Herkunft'  },
                          { value: 'UMWELTEXPOSITION', label: 'Umweltexposition'  },
                        ],
                      },
                    }
                  ]
                },
            ],
          },
        },
        {
        key: 'beschreibungDesEntstehens',
        type: 'repeat',
        templateOptions: {
          addText: 'Weitere Beschreibungen des Entstehens hinzufügen',
        },
        fieldArray: {
          fieldGroup: [
              {
                key: 'value',
                type: 'input',
                templateOptions: {
                  label: 'Beschreibung des Entstehens',
                  placeholder: 'Bitte Beschreibung des Entstehens angeben',
                  }
                },
              ],
            },
          },
        ],
        },
        {
          key: 'datumZeitpunktDerGenesungValue',
          type: 'input',
          templateOptions: {
            label: 'Datum/Zeitpunkt der Genesung',
            placeholder: 'Bitte Datum der Genesung angeben',
            type: 'date',
          },
        },
        {
          key: 'diagnostischeSicherheit',
          wrappers: ['panel'],
          templateOptions: {
            label: 'Diagnostische Sicherheit',
          },
          fieldGroup: [
            {
              key: 'diagnostischeSicherheitDefiningcode',
              type: 'radio',
              templateOptions: {
                options: [
                  { value: 'VERMUTET', label: 'Vermutet'  },
                  { value: 'WAHRSCHEINLICH', label: 'Wahrscheinlich'  },
                  { value: 'BESTATIGT', label: 'Bestätigt'  },
                ],
              },
            },
          ]
        },
        {
          key: 'diagnoseerlauterungValue',
          type: 'input',
          templateOptions: {
            label: 'Diagnoseerläuterung',
            placeholder: 'Bitte Diagnoseerläuterung angeben',
          }
        },
        {
          key: 'letztesDokumentationsdatumValue',
          type: 'input',
          hide: true,
          templateOptions: {
            type: 'date',
          }
        },
        {
          key: 'language',
          type: 'input',
          hide: true,
        },
      ]
    },
  ];
  onSubmit(model: any) {
    this.ehrService.uploadDiagnosis(this.ehrId, this.model).subscribe(
      response => {
        console.log(response)
        this.getDiagnosis(response.body.uuid);
      }
    )
  }

  getDiagnosis(uid: string) {
    this.ehrService.getDiagnosis(this.ehrId, uid).subscribe(
      response => {
        this.diagnosis = response.body;
        console.log(response)
      }
    )
  }

}
