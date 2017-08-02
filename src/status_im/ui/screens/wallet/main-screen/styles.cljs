(ns status-im.ui.screens.wallet.main-screen.styles
  (:require-macros [status-im.utils.styles :refer [defnstyle]])
  (:require [status-im.components.styles :as common]
            [status-im.utils.platform :as platform]))

(def wallet-container
  {:flex             1
   :background-color common/color-white})

(def toolbar-background common/color-blue4)

;;;;;;;;;;;;;;;;;;
;; Main section ;;
;;;;;;;;;;;;;;;;;;

(def main-section
  {:padding 16
   :background-color common/color-blue4})

(def main-section-top-container
  {:flex-direction :row
   :justify-content :space-between
   :align-items :center})

(def wallet-name
  {:font-size 14
   :color common/color-white})

(def wallet-options-icon
  {:width 24
   :height 24})

(def total-balance-container
  {:margin-top 10
   :align-items :center
   :justify-content :center})

(def total-balance
  {:flex-direction :row})

(def total-balance-value
  {:font-size 30
   :color common/color-white})

(def total-balance-currency
  {:font-size 30
   :margin-left 4
   :color common/color-gray7})

(def value-variation
  {:flex-direction :row
   :align-items :center})

(def value-variation-title
  {:font-size 14
   :color common/color-gray7})

(def today-variation-container
  {:border-radius 10
   :margin-left 5
   :padding-horizontal 8
   :padding-vertical 2
   :background-color common/color-green-1})

(def today-variation
  {:font-size 14
   :color common/color-green-2})

;;;;;;;;;;;;;;;;;;;;
;; Assets section ;;
;;;;;;;;;;;;;;;;;;;;

(def asset-section
  {:background-color common/color-white
   :padding-vertical 16})

(def asset-section-title
  {:font-size 14
   :margin-left 16
   :color common/color-gray4})

(def asset-list {})

(def asset-item-container
  {:flex-direction :row
   :align-items      :center
   :padding-horizontal 16
   :padding-vertical 10})

(def asset-item-currency-icon
  {:height 40
   :width 40
   :margin-right 16})

(def asset-item-value-container
  {:flex 1
   :flex-direction :row})

(def asset-item-value
  {:font-size 16
   :color common/color-black})

(def asset-item-currency
  {:font-size 16
   :color common/color-gray4})

(def asset-item-details-icon
  {:flex-shrink 1
   :height 40
   :width 40})

(def asset-list-separator
  {:margin-left 70
   :border-bottom-width 1
   :border-color common/color-separator})

;;;;;;;;;;;;;;;;;;;;
;; Action buttons ;;
;;;;;;;;;;;;;;;;;;;;

(def action-buttons-container
  {:flex-direction :row
   :background-color common/color-blue5
   :margin-top   24
   :border-radius 7})

(def action-button
  {:padding-horizontal 26
   :padding-vertical   12})

(def action-button-center
  (merge action-button
         {:border-color common/color-blue6
          :border-left-width 1
          :border-right-width 1}))

(def action-button-text
  {:font-size 14
   :color common/color-white})
