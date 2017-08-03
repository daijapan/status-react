(ns status-im.ui.screens.wallet.wallet-list.styles
  (:require-macros [status-im.utils.styles :refer [defnstyle]])
  (:require [status-im.components.styles :as common]
            [status-im.utils.platform :as platform]))

(def screen-container
  {:flex             1
   :background-color common/color-white})

(def wallet-colors
  {:blue-1 "#4360df"
   :gray-1 "#3c3d4e"})

;;;;;;;;;;;;;;;;;
;; Wallet list ;;
;;;;;;;;;;;;;;;;;

(def wallet-list-screen
  {:padding 16})

(def wallet-list-title
  {:font-size     14
   :margin-bottom 10
   :color         common/color-gray4})

;;;;;;;;;;;;;;;
;; List item ;;
;;;;;;;;;;;;;;;

(defn wallet-item [color]
  {:flex 1
   :flex-direction     :row
   :align-items        :center
   :border-radius      7
   :padding-horizontal 16
   :padding-vertical   10
   :background-color   (get wallet-colors color)
   :margin-top         8
   :margin-bottom      8})

(def wallet-info
  {:flex-grow 1})

(def wallet-name
  {:font-size 14
   :color     common/color-white})

(def total-balance
  {:margin-top     8
   :margin-bottom  8
   :flex-direction :row})

(def total-balance-value
  {:font-size 24
   :color     common/color-white})

(def total-balance-currency
  {:font-size   24
   :margin-left 6
   :color       "#ffffff77"})

(def asset-list
  {:font-size 14
   :color "#ffffff77"})

(def select-wallet-icon
  {:height      20
   :width       20})
